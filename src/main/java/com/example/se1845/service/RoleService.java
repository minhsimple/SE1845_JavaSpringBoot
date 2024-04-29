package com.example.se1845.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.RoleDTO;

public interface RoleService {
    public ResponseEntity<Object> createRole(RoleDTO roleDto);

    public ResponseEntity<Object> updateRole(String roleid, RoleDTO roleDto);

    public ResponseEntity<Object> getRoleById(String roleid);

    public List<RoleDTO> getAllRole();

    public ResponseEntity<Object> deleteRole(String roleid);
}
