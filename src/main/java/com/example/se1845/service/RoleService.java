package com.example.se1845.service;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.RoleDTO;

public interface RoleService {
    public ResponseEntity<Object> createRole(RoleDTO roleDto);

    public ResponseEntity<Object> updateRole(String roleid, RoleDTO roleDto);

    public ResponseEntity<Object> getRoleById(String roleid);

    public ResponseEntity<Object> getAllRole();

    public ResponseEntity<Object> deleteRole(String roleid);
}
