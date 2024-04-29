package com.example.se1845.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.model.Employee;

@Component
public class EmployeeConverter {
    private ModelMapper modelMapper;

    public EmployeeConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Employee.class, EmployeeDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getDept().getDeptno(), EmployeeDTO::setDeptNo);
                    mapper.map(src -> src.getRole().getRoleid(), EmployeeDTO::setRoleid);
                });

        modelMapper.typeMap(EmployeeDTO.class, Employee.class)
                .addMappings(mapper -> {
                    mapper.<String>map(EmployeeDTO::getDeptNo, (dest, value) -> dest.getDept().setDeptno(value));
                    mapper.skip(Employee::setEwps);
                    mapper.skip(Employee::setErds);
                });
    }

    public Employee toEmployee(EmployeeDTO employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}