package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Emp_Relation_Dep;
import com.example.se1845.model.CompositeKey.Emp_Relation_Dep_Key;

public interface Emp_Relation_DepService {
    public ResponseEntity<Object> createEmp_Relation_Dep(Emp_Relation_Dep erd);

    public ResponseEntity<Object> updateEmp_Relation_Dep(Emp_Relation_Dep_Key id, Emp_Relation_Dep erd);

    public Optional<Emp_Relation_Dep> getEmp_Relation_DepId(Emp_Relation_Dep_Key id);

    public Iterable<Emp_Relation_Dep> getAllEmp_Relation_Dep();

    public ResponseEntity<Object> deleteEmp_Relation_Dep(Emp_Relation_Dep_Key id);
}
