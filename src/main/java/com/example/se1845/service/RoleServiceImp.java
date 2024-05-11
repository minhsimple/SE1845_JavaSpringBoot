package com.example.se1845.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.converter.RoleConverter;
import com.example.se1845.dto.RoleDTO;
import com.example.se1845.model.Role;
import com.example.se1845.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public ResponseEntity<Object> createRole(RoleDTO roleDto) {
        Role role = roleConverter.toRole(roleDto);
        roleRepository.save(role);
        return new ResponseEntity<>(roleDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateRole(String roleid, RoleDTO roleDto) {
        if (roleRepository.existsById(roleid)) {
            Role role = roleConverter.toRole(roleDto);
            roleRepository.save(role);
            return new ResponseEntity<>(roleDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getRoleById(String roleid) {
        Optional<Role> roleOptional = roleRepository.findById(roleid);
        if (!roleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Role role = roleOptional.get();
        RoleDTO roleDto = roleConverter.toRoleDTO(role);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllRole() {
        Iterable<Role> roles = roleRepository.findAll();
        List<RoleDTO> roleDtos = new ArrayList<>();
        for (Role role : roles) {
            RoleDTO roleDto = roleConverter.toRoleDTO(role);
            roleDtos.add(roleDto);
        }
        return new ResponseEntity<>(roleDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteRole(String roleid) {
        if (roleRepository.existsById(roleid)) {
            roleRepository.deleteById(roleid);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
