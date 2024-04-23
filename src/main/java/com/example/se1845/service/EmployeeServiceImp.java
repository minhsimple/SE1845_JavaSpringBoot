package com.example.se1845.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.converter.EmployeeConverter;
import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.model.Employee;
import com.example.se1845.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public ResponseEntity<Object> createEmployee(EmployeeDTO employeeDto) {
        Employee employee = employeeConverter.toEmployee(employeeDto);
        employeeRepository.save(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateEmployee(String ssn, EmployeeDTO employeeDto) {
        if (employeeRepository.existsById(ssn)) {
            Employee employee = employeeConverter.toEmployee(employeeDto);
            employeeRepository.save(employee);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public EmployeeDTO getEmployeeById(String ssn) {
        Optional<Employee> employeeOptional = employeeRepository.findById(ssn);
        if (!employeeOptional.isPresent()) {
            return null;
        }
        Employee employee = employeeOptional.get();
        EmployeeDTO employeeDto = employeeConverter.toEmployeeDTO(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDto = employeeConverter.toEmployeeDTO(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(String ssn) {
        if (employeeRepository.existsById(ssn)) {
            employeeRepository.deleteById(ssn);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
