package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.Emp_WorkOn_Pro;
import com.example.se1845.model.CompositeKey.Emp_WorkOn_Pro_Key;

public interface Emp_WorkOn_ProRepository extends CrudRepository<Emp_WorkOn_Pro, Emp_WorkOn_Pro_Key>{
    
}
