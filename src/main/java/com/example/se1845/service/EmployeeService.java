package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Employee;

public interface EmployeeService {
    public ResponseEntity<Object> createEmployee(Employee employee);

    public ResponseEntity<Object> updateEmployee(String ssn, Employee employee);

    public Optional<Employee> getEmployeeBySsn(String ssn);

    public Iterable<Employee> getAllEmployees();

    public ResponseEntity<Object> deleteEmployee(String ssn);
}
