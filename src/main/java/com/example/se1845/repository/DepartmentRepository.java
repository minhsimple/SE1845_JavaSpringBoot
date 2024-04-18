package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, String> {
    public Department findOneByDeptno(String deptNo);
}
