package com.example.se1845.service;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.AuthenticationRequest;
import com.example.se1845.dto.ChangePassword;
import com.example.se1845.dto.EmployeeDTO;

public interface AuthenticationService {
    public ResponseEntity<Object> authenticate(AuthenticationRequest request);

    public ResponseEntity<Object> register(EmployeeDTO account);

    public ResponseEntity<Object> sendOtpVerifyMailChangePassword(String email);

    public Integer otpGenerator();

    public ResponseEntity<Object> verifyOtp(int otp, String email);

    public ResponseEntity<Object> changePassword(ChangePassword changePassword, String email);
}
