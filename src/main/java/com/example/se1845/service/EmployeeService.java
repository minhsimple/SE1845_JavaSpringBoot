package com.example.se1845.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.model.Employee;

public interface EmployeeService {
    public ResponseEntity<Object> createEmployee(EmployeeDTO employeeDto);

    public ResponseEntity<Object> updateEmployee(String ssn, EmployeeDTO employeeDto);

    public ResponseEntity<Object> getEmployeeById(String ssn);

    public Optional<Employee> findEmployeeByEmail(String email);

    public List<EmployeeDTO> getAllEmployee();

    public ResponseEntity<Object> deleteEmployee(String ssn);
}
