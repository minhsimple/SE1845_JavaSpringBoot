package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Emp_WorkOn_Pro;
import com.example.se1845.model.CompositeKey.Emp_WorkOn_Pro_Key;

public interface Emp_WorkOn_ProService {
    public ResponseEntity<Object> createEmp_WorkOn_Pro(Emp_WorkOn_Pro ewp);

    public ResponseEntity<Object> updateEmp_WorkOn_Pro(Emp_WorkOn_Pro_Key id, Emp_WorkOn_Pro ewp);

    public Optional<Emp_WorkOn_Pro> getEmp_WorkOn_ProId(Emp_WorkOn_Pro_Key id);

    public Iterable<Emp_WorkOn_Pro> getAllEmp_WorkOn_Pro();

    public ResponseEntity<Object> deleteEmp_WorkOn_Pro(Emp_WorkOn_Pro_Key id);
}
