package com.example.se1845.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.se1845.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    public Department findOneByDeptno(String deptNo);
}
