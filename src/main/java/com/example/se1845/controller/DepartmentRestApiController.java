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

import com.example.se1845.dto.DepartmentDTO;
import com.example.se1845.service.DepartmentService;

import jakarta.validation.Valid;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/departments")
public class DepartmentRestApiController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Object> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{deptNo}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable String deptNo) {
        return departmentService.getDepartmentById(deptNo);
    }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@Valid @RequestBody DepartmentDTO departmentDto) {
        return departmentService.createDepartment(departmentDto);
    }

    @PutMapping("/{deptNo}")
    public ResponseEntity<Object> updateDepartment(@PathVariable String deptNo,
            @Valid @RequestBody DepartmentDTO departmentDto) {
        return departmentService.updateDepartment(deptNo, departmentDto);
    }

    @DeleteMapping("/{deptNo}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable String deptNo) {
        return departmentService.deleteDepartment(deptNo);
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
