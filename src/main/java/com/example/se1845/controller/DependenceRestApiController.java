package com.example.se1845.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.se1845.model.Dependence;
import com.example.se1845.service.DependenceService;

@RestController
@RequestMapping("/dependences")
public class DependenceRestApiController {

    @Autowired
    private DependenceService dependenceService;

    @GetMapping
    public Iterable<Dependence> getAllDependences() {
        return dependenceService.getAllDependence();
    }

    @GetMapping("/{depId}")
    public Optional<Dependence> getDependenceById(String depId) {
        return dependenceService.getDependenceById(depId);
    }

    @PostMapping
    public ResponseEntity<Object> createDependence(@RequestBody Dependence dep) {
        return dependenceService.createDependence(dep);
    }

    @PutMapping("/{depId}")
    public ResponseEntity<Object> updateDependence(@PathVariable String depId, @RequestBody Dependence dep) {
        return dependenceService.updateDependence(depId, dep);
    }

    @DeleteMapping("/{depId}")
    public ResponseEntity<Object> deleteDependence(@PathVariable String depId) {
        return dependenceService.deleteDependence(depId);
    }
}
