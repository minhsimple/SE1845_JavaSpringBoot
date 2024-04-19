package com.example.se1845.converter;

import org.springframework.stereotype.Component;

import com.example.se1845.dto.DepartmentDTO;
import com.example.se1845.model.Department;

@Component
public class DepartmentConverter {

    public Department toDepartment(DepartmentDTO departmentDto) {
        Department department = new Department();
        department.setDeptno(departmentDto.getDeptno());
        department.setName(departmentDto.getName());
        department.setLocation(departmentDto.getLocation());

        return department;
    }

    public DepartmentDTO toDepartmentDTO(Department department) {
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setDeptno(department.getDeptno());
        departmentDto.setName(department.getName());
        departmentDto.setLocation(department.getLocation());

        return departmentDto;
    }

    public Department toDepartment(DepartmentDTO departmentDto, Department department) {
        department.setName(departmentDto.getName());
        department.setLocation(departmentDto.getLocation());

        return department;
    }
}
