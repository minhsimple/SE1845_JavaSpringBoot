package com.example.se1845.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.model.EmpWorkOnPro;
import com.example.se1845.model.CompositeKey.EmpWorkOnProKey;
import com.example.se1845.repository.EmpWorkOnProRepository;

@Service
public class EmpWorkOnProServiceImp implements EmpWorkOnProService {

    @Autowired
    private EmpWorkOnProRepository empWorkOnProRepository;

    @Override
    public ResponseEntity<Object> createEmpWorkOnPro(EmpWorkOnPro ewp) {
        return new ResponseEntity<>(empWorkOnProRepository.save(ewp), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateEmpWorkOnPro(EmpWorkOnProKey id, EmpWorkOnPro ewp) {
        return (empWorkOnProRepository.existsById(id))
                ? new ResponseEntity<>(empWorkOnProRepository.save(ewp), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<EmpWorkOnPro> getEmpWorkOnProById(EmpWorkOnProKey id) {
        return empWorkOnProRepository.findById(id);
    }

    @Override
    public Iterable<EmpWorkOnPro> getAllEmpWorkOnPro() {
        return empWorkOnProRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteEmpWorkOnPro(EmpWorkOnProKey id) {
        empWorkOnProRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
