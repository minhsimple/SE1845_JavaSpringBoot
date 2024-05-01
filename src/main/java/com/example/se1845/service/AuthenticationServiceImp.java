package com.example.se1845.service;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.se1845.Config.JwtUtil;
import com.example.se1845.dto.AuthenticationRequest;
import com.example.se1845.dto.AuthenticationResponse;
import com.example.se1845.dto.ChangePassword;
import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.dto.MailBody;
import com.example.se1845.model.Employee;
import com.example.se1845.repository.EmployeeRepository;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmailService emailService;

    @Override
    public ResponseEntity<Object> authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("AuthenticationManager authenticate error", HttpStatus.UNAUTHORIZED);
        }

        final UserDetails user = employeeService.findEmployeeByEmail(request.getEmail()).get();
        AuthenticationResponse response = new AuthenticationResponse(jwtUtil.generateToken(user));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> register(EmployeeDTO account) {
        employeeService.createEmployee(account);
        final UserDetails user = employeeService.findEmployeeByEmail(account.getEmail()).get();
        AuthenticationResponse response = new AuthenticationResponse(jwtUtil.generateToken(user));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> sendOtpVerifyMailChangePassword(String email) {
        Employee employee = employeeService.findEmployeeByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));

        int otp = otpGenerator();

        MailBody mailBody = MailBody.builder()
                .to(email)
                .text("This is the OTP for your forgot password request : " + otp)
                .subject("OTP for forgot password request")
                .build();

        emailService.sendSimpleMessage(mailBody);

        employee.setForgotPasswordOtp(otp);
        employee.setOtpExpired(new Date(System.currentTimeMillis() + 70 * 1000));

        employeeRepository.save(employee);

        return new ResponseEntity<>("OTP sent to your email", HttpStatus.OK);
    }

    @Override
    public Integer otpGenerator() {
        Random random = new Random();
        return random.nextInt(100_000, 999_999);
    }

    @Override
    public ResponseEntity<Object> verifyOtp(int otp, String email) {
        Employee employee = employeeRepository.findOneByEmailAndForgotPasswordOtp(email, otp)
                .orElseThrow(() -> new RuntimeException("Invalid OTP or Email"));

        if (employee.getOtpExpired().before(Date.from(Instant.now()))) {
            employee.setForgotPasswordOtp(null);
            employee.setOtpExpired(null);
            employeeRepository.save(employee);
            return new ResponseEntity<>("OTP expired", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("OTP verified", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> changePassword(ChangePassword changePassword, String email) {
        if (!Objects.equals(changePassword.password(), changePassword.repeatPassword())) {
            return new ResponseEntity<>("Confirm password does not match", HttpStatus.BAD_REQUEST);
        }

        employeeRepository.updatePasswordByEmail(email, changePassword.password());
        return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
    }

}
