package com.example.se1845.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.se1845.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
