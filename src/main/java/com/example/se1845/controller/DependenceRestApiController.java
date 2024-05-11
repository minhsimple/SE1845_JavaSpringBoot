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

import com.example.se1845.dto.DependenceDTO;
import com.example.se1845.service.DependenceService;

import jakarta.validation.Valid;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/dependences")
public class DependenceRestApiController {

    @Autowired
    private DependenceService dependenceService;

    @GetMapping
    public ResponseEntity<Object> getAllDependences() {
        return dependenceService.getAllDependence();
    }

    @GetMapping("/{depId}")
    public ResponseEntity<Object> getDependenceById(@PathVariable String depId) {
        return dependenceService.getDependenceById(depId);
    }

    @PostMapping
    public ResponseEntity<Object> createDependence(@Valid @RequestBody DependenceDTO depDto) {
        return dependenceService.createDependence(depDto);
    }

    @PutMapping("/{depId}")
    public ResponseEntity<Object> updateDependence(@PathVariable String depId,
            @Valid @RequestBody DependenceDTO depDto) {
        return dependenceService.updateDependence(depId, depDto);
    }

    @DeleteMapping("/{depId}")
    public ResponseEntity<Object> deleteDependence(@PathVariable String depId) {
        return dependenceService.deleteDependence(depId);
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
