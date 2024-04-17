package com.example.se1845.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.model.EmpRelationDep;
import com.example.se1845.model.CompositeKey.EmpRelationDepKey;
import com.example.se1845.repository.EmpRelationDepRepository;

@Service
public class EmpRelationDepServiceImp implements EmpRelationDepService {

    @Autowired
    private EmpRelationDepRepository empRelationDepRepository;

    @Override
    public ResponseEntity<Object> createEmpRelationDep(EmpRelationDep erd) {
        return new ResponseEntity<>(empRelationDepRepository.save(erd), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateEmpRelationDep(EmpRelationDepKey id, EmpRelationDep erd) {
        return (empRelationDepRepository.existsById(id))
                ? new ResponseEntity<>(empRelationDepRepository.save(erd), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<EmpRelationDep> getEmpRelationDepById(EmpRelationDepKey id) {
        return empRelationDepRepository.findById(id);
    }

    @Override
    public Iterable<EmpRelationDep> getAllEmpRelationDep() {
        return empRelationDepRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteEmpRelationDep(EmpRelationDepKey id) {
        empRelationDepRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
