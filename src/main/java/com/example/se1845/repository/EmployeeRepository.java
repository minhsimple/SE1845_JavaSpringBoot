package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
