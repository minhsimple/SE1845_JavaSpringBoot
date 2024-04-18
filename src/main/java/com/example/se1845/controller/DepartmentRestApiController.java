package com.example.se1845.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.se1845.model.Department;
import com.example.se1845.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentRestApiController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Iterable<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{deptNo}")
    public Optional<Department> getDepartmentById(@PathVariable String deptNo) {
        return departmentService.getDepartmentById(deptNo);
    }
    // @GetMapping("/{deptId}")
    // public Department getDepartmentById(@PathVariable String deptId) {
    // return departmentService.getOneByDeptNo(deptId);
    // }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<Object> updateDepartment(@PathVariable String deptNo, @RequestBody Department department) {
        return departmentService.updateDepartment(deptNo, department);
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable String deptNo) {
        return departmentService.deleteDepartment(deptNo);
    }
}
