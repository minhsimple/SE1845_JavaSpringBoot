package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.EmpRelationDep;
import com.example.se1845.model.CompositeKey.EmpRelationDepKey;

public interface EmpRelationDepService {
    public ResponseEntity<Object> createEmp_Relation_Dep(EmpRelationDep erd);

    public ResponseEntity<Object> updateEmp_Relation_Dep(EmpRelationDepKey id, EmpRelationDep erd);

    public Optional<EmpRelationDep> getEmp_Relation_DepById(EmpRelationDepKey id);

    public Iterable<EmpRelationDep> getAllEmp_Relation_Dep();

    public ResponseEntity<Object> deleteEmp_Relation_Dep(EmpRelationDepKey id);
}
