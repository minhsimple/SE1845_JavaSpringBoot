package com.example.se1845.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.model.Department;
import com.example.se1845.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<Object> createDepartment(Department depart) {
        return new ResponseEntity<>(departmentRepository.save(depart), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateDepartment(String deptId, Department depart) {
        return (departmentRepository.existsById(deptId))
                ? new ResponseEntity<>(departmentRepository.save(depart), HttpStatus.OK)
                : new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<Department> getDepartmentById(String deptId) {
        return departmentRepository.findById(deptId);
    }

    @Override
    public Iterable<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(String deptId) {
        departmentRepository.deleteById(deptId);
        return new ResponseEntity<>("Department deleted", HttpStatus.OK);
    }

}
