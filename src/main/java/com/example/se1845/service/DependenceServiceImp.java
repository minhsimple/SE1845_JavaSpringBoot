package com.example.se1845.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.model.Dependence;
import com.example.se1845.repository.DependenceRepository;

@Service
public class DependenceServiceImp implements DependenceService {

    @Autowired
    private DependenceRepository depRepo;

    @Override
    public ResponseEntity<Object> createDependence(Dependence dep) {
        return new ResponseEntity<>(depRepo.save(dep), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateDependence(String depId, Dependence dep) {
        return (depRepo.existsById(depId)) ? new ResponseEntity<>(depRepo.save(dep), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<Dependence> getDependenceById(String depId) {
        return depRepo.findById(depId);
    }

    @Override
    public Iterable<Dependence> getAllDependence() {
        return depRepo.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteDependence(String depId) {
        depRepo.deleteById(depId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
