package com.example.se1845.controller;

import java.util.List;

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

import com.example.se1845.dto.DepartmentDTO;
import com.example.se1845.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentRestApiController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{deptNo}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable String deptNo) {
        return departmentService.getDepartmentById(deptNo);
    }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody DepartmentDTO departmentDto) {
        return departmentService.createDepartment(departmentDto);
    }

    @PutMapping("/{deptNo}")
    public ResponseEntity<Object> updateDepartment(@PathVariable String deptNo,
            @RequestBody DepartmentDTO departmentDto) {
        return departmentService.updateDepartment(deptNo, departmentDto);
    }

    @DeleteMapping("/{deptNo}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable String deptNo) {
        return departmentService.deleteDepartment(deptNo);
    }
}
