package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.EmpWorkOnPro;
import com.example.se1845.model.CompositeKey.EmpWorkOnProKey;

public interface EmpWorkOnProService {
    public ResponseEntity<Object> createEmpWorkOnPro(EmpWorkOnPro ewp);

    public ResponseEntity<Object> updateEmpWorkOnPro(EmpWorkOnProKey id, EmpWorkOnPro ewp);

    public Optional<EmpWorkOnPro> getEmpWorkOnProId(EmpWorkOnProKey id);

    public Iterable<EmpWorkOnPro> getAllEmpWorkOnPro();

    public ResponseEntity<Object> deleteEmpWorkOnPro(EmpWorkOnProKey id);
}
