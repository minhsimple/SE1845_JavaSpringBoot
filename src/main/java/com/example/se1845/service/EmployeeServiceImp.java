package com.example.se1845.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Object> createEmployee(EmployeeDTO employeeDto) {
        employeeDto.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
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
    public ResponseEntity<Object> getEmployeeById(String ssn) {
        Optional<Employee> employeeOptional = employeeRepository.findById(ssn);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = employeeOptional.get();
        EmployeeDTO employeeDto = employeeConverter.toEmployeeDTO(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
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

    @Override
    public Optional<Employee> findEmployeeByEmail(String email) {
        return employeeRepository.findOneByEmail(email);
    }

    @Override
    public void updateOtpInfoByEmail(String email, Integer forgotPasswordOtp, Date otpExpired) {
        employeeRepository.updateOtpInfoByEmail(email, forgotPasswordOtp, otpExpired);
    }

    @Override
    public Optional<Employee> findOneByEmailAndForgotPasswordOtp(String email, Integer forgotPasswordOtp) {
        return employeeRepository.findOneByEmailAndForgotPasswordOtp(email, forgotPasswordOtp);
    }

    @Override
    public void updatePasswordByEmail(String email, String password) {
        employeeRepository.updatePasswordByEmail(email, password);
    }

}
