package com.example.se1845.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.se1845.model.EmpWorkOnPro;
import com.example.se1845.model.CompositeKey.EmpWorkOnProKey;

public interface EmpWorkOnProRepository extends CrudRepository<EmpWorkOnPro, EmpWorkOnProKey>{
    
}
