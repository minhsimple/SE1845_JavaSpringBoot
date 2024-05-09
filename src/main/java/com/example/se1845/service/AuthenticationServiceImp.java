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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.se1845.Config.JwtUtil;
import com.example.se1845.converter.EmployeeConverter;
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
    private AuthenticationRequest authenticationRequest;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository employeeRepository;

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

        authenticationRequest.setEmail(request.getEmail());
        final UserDetails user = employeeRepository.findOneByEmail(request.getEmail()).get();
        AuthenticationResponse response = new AuthenticationResponse(jwtUtil.generateToken(user));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> register(EmployeeDTO account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        employeeRepository.save(employeeConverter.toEmployee(account));

        final UserDetails user = employeeRepository.findOneByEmail(account.getEmail()).get();
        AuthenticationResponse response = new AuthenticationResponse(jwtUtil.generateToken(user));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> sendOtpVerifyMailChangePassword(String email) {

        if (employeeRepository.findOneByEmail(email).isPresent()) {
            int otp = otpGenerator();

            MailBody mailBody = MailBody.builder()
                    .to(email)
                    .text("This is the OTP for your forgot password request : " + otp)
                    .subject("OTP for forgot password request")
                    .build();

            emailService.sendSimpleMessage(mailBody);

            employeeRepository.updateOtpInfoByEmail(email, otp, new Date(System.currentTimeMillis() + 120 * 1000));

            return new ResponseEntity<>("OTP sent to your email", HttpStatus.OK);
        }
        return new ResponseEntity<>("Email not found", HttpStatus.BAD_REQUEST);
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
            employeeRepository.updateOtpInfoByEmail(email, null, null);
            return new ResponseEntity<>("OTP expired", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("OTP verified", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> changePassword(ChangePassword changePassword, String email) {
        if (!Objects.equals(changePassword.password(), changePassword.repeatPassword())) {
            return new ResponseEntity<>("Confirm password does not match", HttpStatus.BAD_REQUEST);
        }

        String encodePassword = passwordEncoder.encode(changePassword.password());
        employeeRepository.updatePasswordByEmail(email, encodePassword);
        return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
    }

}
