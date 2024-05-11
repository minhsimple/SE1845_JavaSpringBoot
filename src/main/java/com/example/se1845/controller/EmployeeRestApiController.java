package com.example.se1845.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/employees")
public class EmployeeRestApiController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Object> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<Object> getEmployeeBySsn(@PathVariable String ssn) {
        return employeeService.getEmployeeById(ssn);
    }

    @PostMapping
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeDTO employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{ssn}")
    public ResponseEntity<Object> updateEmployee(@PathVariable String ssn,
            @Valid @RequestBody EmployeeDTO employeeDto) {
        return employeeService.updateEmployee(ssn, employeeDto);
    }

    @DeleteMapping("/{ssn}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String ssn) {
        return employeeService.deleteEmployee(ssn);
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
