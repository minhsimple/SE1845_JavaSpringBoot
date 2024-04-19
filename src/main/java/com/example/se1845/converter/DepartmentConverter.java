package com.example.se1845.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.se1845.dto.DepartmentDTO;
import com.example.se1845.model.Department;

@Component
public class DepartmentConverter {
    private ModelMapper modelMapper;

    public DepartmentConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(DepartmentDTO.class, Department.class)
                .addMappings(mapper -> {
                    mapper.skip(Department::setEmps);
                    mapper.skip(Department::setPros);
                });
    }

    public Department toDepartment(DepartmentDTO departmentDto) {
        return modelMapper.map(departmentDto, Department.class);
    }

    public DepartmentDTO toDepartmentDTO(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }
}
