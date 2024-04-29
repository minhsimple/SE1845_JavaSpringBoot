package com.example.se1845.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
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

import com.example.se1845.dto.RoleDTO;
import com.example.se1845.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RoleRestApiController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRole();
    }

    @GetMapping("/{roleid}")
    public ResponseEntity<Object> getRoleById(@PathVariable String roleid) {
        return roleService.getRoleById(roleid);
    }

    @PostMapping
    public ResponseEntity<Object> createRole(@Valid @RequestBody RoleDTO roleDto) {
        return roleService.createRole(roleDto);
    }

    @PutMapping("/{roleid}")
    public ResponseEntity<Object> updateRole(@PathVariable String roleid, @Valid @RequestBody RoleDTO roleDto) {
        return roleService.updateRole(roleid, roleDto);
    }

    @DeleteMapping("/{roleid}")
    public ResponseEntity<Object> deleteRole(@PathVariable String roleid) {
        return roleService.deleteRole(roleid);
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
