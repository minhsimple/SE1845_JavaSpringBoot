package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.EmpRelationDep;
import com.example.se1845.model.CompositeKey.EmpRelationDepKey;

public interface EmpRelationDepRepository extends CrudRepository<EmpRelationDep, EmpRelationDepKey>{

}
