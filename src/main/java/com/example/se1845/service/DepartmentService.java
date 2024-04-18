package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Department;

public interface DepartmentService {
    public ResponseEntity<Object> createDepartment(Department depart);

    public ResponseEntity<Object> updateDepartment(String deptNo, Department depart);

    public Optional<Department> getDepartmentById(String deptNo);

    public Department getOneByDeptNo(String deptNo);

    public Iterable<Department> getAllDepartment();

    public ResponseEntity<Object> deleteDepartment(String deptNo);
}
