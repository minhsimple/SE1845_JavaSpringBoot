package com.example.se1845.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.se1845.Config.JwtUtil;
import com.example.se1845.dto.AuthenticationRequest;
import com.example.se1845.dto.AuthenticationResponse;
import com.example.se1845.dto.EmployeeDTO;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtil jwtUtil;

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

}
