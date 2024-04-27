package com.example.se1845.controller;

import java.util.HashMap;
import java.util.List;
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

import com.example.se1845.dto.ProjectDTO;
import com.example.se1845.service.ProjectService;

import jakarta.validation.Valid;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/projects")
public class ProjectRestApiController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProject();
    }

    @GetMapping("/{prono}")
    public ResponseEntity<Object> getProjectById(@PathVariable String prono) {
        return projectService.getProjectById(prono);
    }

    @PostMapping
    public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectDTO proDto) {
        return projectService.createProject(proDto);
    }

    @PutMapping("/{prono}")
    public ResponseEntity<Object> updateProject(@PathVariable String prono, @Valid @RequestBody ProjectDTO proDto) {
        return projectService.updateProject(prono, proDto);
    }

    @DeleteMapping("/{prono}")
    public ResponseEntity<Object> deleteProject(@PathVariable String prono) {
        return projectService.deleteProject(prono);
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
