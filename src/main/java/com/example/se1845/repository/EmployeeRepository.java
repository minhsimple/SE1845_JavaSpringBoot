package com.example.se1845.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.se1845.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public Optional<Employee> findOneByEmail(String email);
}
