package com.example.se1845.controller;

import java.util.List;

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

import com.example.se1845.dto.DependenceDTO;
import com.example.se1845.service.DependenceService;

@RestController
@RequestMapping("/dependences")
public class DependenceRestApiController {

    @Autowired
    private DependenceService dependenceService;

    @GetMapping
    public List<DependenceDTO> getAllDependences() {
        return dependenceService.getAllDependence();
    }

    @GetMapping("/{depId}")
    public ResponseEntity<Object> getDependenceById(@PathVariable String depId) {
        return dependenceService.getDependenceById(depId);
    }

    @PostMapping
    public ResponseEntity<Object> createDependence(@RequestBody DependenceDTO depDto) {
        return dependenceService.createDependence(depDto);
    }

    @PutMapping("/{depId}")
    public ResponseEntity<Object> updateDependence(@PathVariable String depId, @RequestBody DependenceDTO depDto) {
        return dependenceService.updateDependence(depId, depDto);
    }

    @DeleteMapping("/{depId}")
    public ResponseEntity<Object> deleteDependence(@PathVariable String depId) {
        return dependenceService.deleteDependence(depId);
    }
}
