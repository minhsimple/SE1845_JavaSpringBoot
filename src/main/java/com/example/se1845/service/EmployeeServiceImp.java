package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.model.Employee;
import com.example.se1845.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<Object> createEmployee(Employee employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateEmployee(String ssn, Employee employee) {
        return (employeeRepository.existsById(ssn))
                ? new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK)
                : new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @Override
    public Optional<Employee> getEmployeeById(String ssn) {
        return employeeRepository.findById(ssn);
    }

    @Override
    public Iterable<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(String ssn) {
        employeeRepository.deleteById(ssn);
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }

}
