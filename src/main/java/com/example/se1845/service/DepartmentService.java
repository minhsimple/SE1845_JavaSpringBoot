package com.example.se1845.service;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.DepartmentDTO;
import com.example.se1845.model.Department;

public interface DepartmentService {
    public ResponseEntity<Object> createDepartment(DepartmentDTO departDto);

    public ResponseEntity<Object> updateDepartment(String deptNo, DepartmentDTO departDto);

    public ResponseEntity<Object> getDepartmentById(String deptNo);

    public Department getOneByDeptNo(String deptNo);

    public ResponseEntity<Object> getAllDepartment();

    public ResponseEntity<Object> deleteDepartment(String deptNo);
}
