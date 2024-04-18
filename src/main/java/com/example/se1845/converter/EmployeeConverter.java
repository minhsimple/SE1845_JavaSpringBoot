package com.example.se1845.converter;

import org.springframework.stereotype.Component;

import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.model.Employee;

@Component
public class EmployeeConverter {

    public Employee toEmployee(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setSsn(employeeDto.getSsn());
        employee.setFname(employeeDto.getFname());
        employee.setLname(employeeDto.getLname());
        employee.setAddress(employeeDto.getAddress());
        employee.setSalary(employeeDto.getSalary());
        employee.setSex(employeeDto.isSex());

        return employee;
    }

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setSsn(employee.getSsn());
        employeeDto.setFname(employee.getFname());
        employeeDto.setLname(employee.getLname());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setSex(employee.isSex());

        return employeeDto;
    }

    public Employee toEmployee(EmployeeDTO employeeDto, Employee employee) {
        employee.setFname(employeeDto.getFname());
        employee.setLname(employeeDto.getLname());
        employee.setAddress(employeeDto.getAddress());
        employee.setSalary(employeeDto.getSalary());
        employee.setSex(employeeDto.isSex());

        return employee;
    }
}
