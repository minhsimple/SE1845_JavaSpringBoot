package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Department;

public interface DepartmentService {
    public ResponseEntity<Object> createDepartment(Department depart);

    public ResponseEntity<Object> updateDepartment(String deptId, Department depart);

    public Optional<Department> getDepartmentById(String deptId);

    public Iterable<Department> getAllDepartment();

    public ResponseEntity<Object> deleteDepartment(String deptId);
}
