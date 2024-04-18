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
import com.example.se1845.model.Department;
import com.example.se1845.model.Employee;
import com.example.se1845.repository.DepartmentRepository;
import com.example.se1845.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public ResponseEntity<Object> createEmployee(EmployeeDTO employeeDto) {
        Department department = departmentRepository.findById(employeeDto.getDeptNo()).get();
        Employee employee = employeeConverter.toEmployee(employeeDto);
        employee.setDept(department);
        employeeRepository.save(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateEmployee(String ssn, EmployeeDTO employeeDto) {
        if (employeeRepository.existsById(ssn)) {
            Department department = departmentRepository.findById(employeeDto.getDeptNo()).get();
            Employee employee = employeeRepository.findById(ssn).get();
            employee = employeeConverter.toEmployee(employeeDto, employee);
            employee.setDept(department);
            employeeRepository.save(employee);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> getEmployeeById(String ssn) {
        Optional<Employee> employeeOptional = employeeRepository.findById(ssn);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = employeeOptional.get();
        EmployeeDTO employeeDto = employeeConverter.toEmployeeDTO(employee);
        String deptNo = employee.getDept().getDeptno();
        employeeDto.setDeptNo(deptNo);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            String deptNo = employee.getDept().getDeptno();
            EmployeeDTO employeeDto = employeeConverter.toEmployeeDTO(employee);
            employeeDto.setDeptNo(deptNo);
            employeeDtos.add(employeeDto);
        }

        return employeeDtos;
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(String ssn) {
        employeeRepository.deleteById(ssn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
