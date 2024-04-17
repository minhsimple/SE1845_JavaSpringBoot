package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.EmpRelationDep;
import com.example.se1845.model.CompositeKey.EmpRelationDepKey;

public interface EmpRelationDepService {
    public ResponseEntity<Object> createEmpRelationDep(EmpRelationDep erd);

    public ResponseEntity<Object> updateEmpRelationDep(EmpRelationDepKey id, EmpRelationDep erd);

    public Optional<EmpRelationDep> getEmpRelationDepById(EmpRelationDepKey id);

    public Iterable<EmpRelationDep> getAllEmpRelationDep();

    public ResponseEntity<Object> deleteEmpRelationDep(EmpRelationDepKey id);
}
