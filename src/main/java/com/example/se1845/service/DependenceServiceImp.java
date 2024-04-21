package com.example.se1845.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.converter.DependenceConverter;
import com.example.se1845.dto.DependenceDTO;
import com.example.se1845.model.Dependence;
import com.example.se1845.repository.DependenceRepository;

@Service
public class DependenceServiceImp implements DependenceService {

    @Autowired
    private DependenceRepository depRepo;

    @Autowired
    DependenceConverter depConverter;

    @Override
    public ResponseEntity<Object> createDependence(DependenceDTO depDto) {
        Dependence dependence = depConverter.toDependence(depDto);
        depRepo.save(dependence);
        return new ResponseEntity<>(depDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateDependence(String depId, DependenceDTO depDto) {
        if (depRepo.existsById(depId)) {
            Dependence dependence = depConverter.toDependence(depDto);
            depRepo.save(dependence);
            return new ResponseEntity<>(depDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getDependenceById(String depId) {
        Optional<Dependence> dependence = depRepo.findById(depId);
        if (!dependence.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DependenceDTO depDto = depConverter.toDependenceDTO(dependence.get());
        return new ResponseEntity<>(depDto, HttpStatus.OK);
    }

    @Override
    public List<DependenceDTO> getAllDependence() {
        Iterable<Dependence> dependences = depRepo.findAll();
        List<DependenceDTO> depDtos = new ArrayList<>();
        for (Dependence dep : dependences) {
            depDtos.add(depConverter.toDependenceDTO(dep));
        }
        return depDtos;
    }

    @Override
    public ResponseEntity<Object> deleteDependence(String depId) {
        if (depRepo.existsById(depId)) {
            depRepo.deleteById(depId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
