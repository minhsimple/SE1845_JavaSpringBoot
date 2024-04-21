package com.example.se1845.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.se1845.model.EmpRelationDep;
import com.example.se1845.model.CompositeKey.EmpRelationDepKey;

public interface EmpRelationDepRepository extends JpaRepository<EmpRelationDep, EmpRelationDepKey> {

}
