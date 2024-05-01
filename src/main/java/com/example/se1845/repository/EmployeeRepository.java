package com.example.se1845.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.se1845.model.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public Optional<Employee> findOneByEmail(String email);

    public Optional<Employee> findOneByEmailAndForgotPasswordOtp(String email, Integer forgotPasswordOtp);

    @Modifying
    @Transactional
    @Query("update Employee e set e.password = ?2 where e.email = ?1")
    public void updatePasswordByEmail(String email, String password);
}
