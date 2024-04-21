package com.example.se1845.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestApiController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<Object> getEmployeeBySsn(@PathVariable String ssn) {
        return employeeService.getEmployeeById(ssn);
    }

    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDTO employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{ssn}")
    public ResponseEntity<Object> updateEmployee(@PathVariable String ssn, @RequestBody EmployeeDTO employeeDto) {
        return employeeService.updateEmployee(ssn, employeeDto);
    }

    @DeleteMapping("/{ssn}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String ssn) {
        return employeeService.deleteEmployee(ssn);
    }
}
