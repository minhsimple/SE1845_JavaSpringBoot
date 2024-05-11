package com.example.se1845.service;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.DependenceDTO;

public interface DependenceService {
    public ResponseEntity<Object> createDependence(DependenceDTO dep);

    public ResponseEntity<Object> updateDependence(String depId, DependenceDTO dep);

    public ResponseEntity<Object> getDependenceById(String depId);

    public ResponseEntity<Object> getAllDependence();

    public ResponseEntity<Object> deleteDependence(String depId);
}
