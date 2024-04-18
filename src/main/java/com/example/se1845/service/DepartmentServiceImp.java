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
    public ResponseEntity<Object> updateDepartment(String deptNo, Department depart) {
        return (departmentRepository.existsById(deptNo))
                ? new ResponseEntity<>(departmentRepository.save(depart), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<Department> getDepartmentById(String deptNo) {
        return departmentRepository.findById(deptNo);
    }

    @Override
    public Department getOneByDeptNo(String deptNo) {
        return departmentRepository.findOneByDeptno(deptNo);
    }

    @Override
    public Iterable<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(String deptNo) {
        departmentRepository.deleteById(deptNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
