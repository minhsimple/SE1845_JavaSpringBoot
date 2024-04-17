package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.Emp_Relation_Dep;
import com.example.se1845.model.CompositeKey.Emp_Relation_Dep_Key;

public interface Emp_Relation_DepRepository extends CrudRepository<Emp_Relation_Dep, Emp_Relation_Dep_Key>{

}
