package com.example.se1845.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.se1845.model.EmpWorkOnPro;
import com.example.se1845.model.CompositeKey.EmpWorkOnProKey;

public interface EmpWorkOnProRepository extends JpaRepository<EmpWorkOnPro, EmpWorkOnProKey> {

}
