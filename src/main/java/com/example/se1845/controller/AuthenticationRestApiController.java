package com.example.se1845.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.se1845.dto.AuthenticationRequest;
import com.example.se1845.dto.ChangePassword;
import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestApiController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody EmployeeDTO account) {
        return authenticationService.register(account);
    }

    @PostMapping("/forgotpassword/{email}")
    public ResponseEntity<Object> sendOtpVerifyMailChangePassword(@PathVariable String email) {
        return authenticationService.sendOtpVerifyMailChangePassword(email);
    }

    @PostMapping("/verifyotp/{otp}/{email}")
    public ResponseEntity<Object> verifyOtp(@PathVariable int otp, @PathVariable String email) {
        return authenticationService.verifyOtp(otp, email);
    }

    @PostMapping("/changepassword/{email}")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePassword changePassword,
            @PathVariable String email) {
        return authenticationService.changePassword(changePassword, email);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}