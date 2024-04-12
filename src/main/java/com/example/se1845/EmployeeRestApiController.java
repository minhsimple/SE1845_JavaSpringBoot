package com.example.se1845;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeRestApiController {
    private final EmployeeRepository employeeRepository;

    public EmployeeRestApiController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{ssn}")
    public Optional<Employee> getEmployeeBySsn(@PathVariable String ssn) {
        return employeeRepository.findById(ssn);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{ssn}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String ssn, @RequestBody Employee employee) {
        return (employeeRepository.existsById(ssn))
                ? new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK)
                : new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{ssn}")
    public void deleteEmployee(@PathVariable String ssn) {
        employeeRepository.deleteById(ssn);
    }
}
