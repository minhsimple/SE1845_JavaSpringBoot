package com.example.se1845.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.converter.DepartmentConverter;
import com.example.se1845.dto.DepartmentDTO;
import com.example.se1845.model.Department;
import com.example.se1845.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentConverter departmentConverter;

    @Override
    public ResponseEntity<Object> createDepartment(DepartmentDTO departDto) {
        Department department = departmentConverter.toDepartment(departDto);
        departmentRepository.save(department);
        return new ResponseEntity<>(departDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateDepartment(String deptNo, DepartmentDTO departDto) {
        if (departmentRepository.existsById(deptNo)) {
            Department department = departmentConverter.toDepartment(departDto);
            departmentRepository.save(department);
            return new ResponseEntity<>(departDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getDepartmentById(String deptNo) {
        if (!departmentRepository.existsById(deptNo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Department department = departmentRepository.findById(deptNo).get();
        DepartmentDTO departmentDto = departmentConverter.toDepartmentDTO(department);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @Override
    public Department getOneByDeptNo(String deptNo) {
        return departmentRepository.findOneByDeptno(deptNo);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        Iterable<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDtos = new ArrayList<>();
        for (Department department : departments) {
            departmentDtos.add(departmentConverter.toDepartmentDTO(department));
        }
        return departmentDtos;
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(String deptNo) {
        if (departmentRepository.existsById(deptNo)) {
            departmentRepository.deleteById(deptNo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
