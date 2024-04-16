package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Dependence;

public interface DependenceService {
    public ResponseEntity<Object> createDependence(Dependence dep);

    public ResponseEntity<Object> updateDependence(String depId, Dependence dep);

    public Optional<Dependence> getDependenceById(String depId);

    public Iterable<Dependence> getAllDependence();

    public ResponseEntity<Object> deleteDependence(String depId);
}
