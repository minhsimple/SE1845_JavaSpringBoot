package com.example.se1845.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.DependenceDTO;

public interface DependenceService {
    public ResponseEntity<Object> createDependence(DependenceDTO dep);

    public ResponseEntity<Object> updateDependence(String depId, DependenceDTO dep);

    public DependenceDTO getDependenceById(String depId);

    public List<DependenceDTO> getAllDependence();

    public ResponseEntity<Object> deleteDependence(String depId);
}
