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

import com.example.se1845.dto.ProjectDTO;
import com.example.se1845.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectRestApiController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProject();
    }

    @GetMapping("/{prono}")
    public ResponseEntity<Object> getProjectById(@PathVariable String prono) {
        return projectService.getProjectById(prono);
    }

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody ProjectDTO proDto) {
        return projectService.createProject(proDto);
    }

    @PutMapping("/{prono}")
    public ResponseEntity<Object> updateProject(@PathVariable String prono, @RequestBody ProjectDTO proDto) {
        return projectService.updateProject(prono, proDto);
    }

    @DeleteMapping("/{prono}")
    public ResponseEntity<Object> deleteProject(@PathVariable String prono) {
        return projectService.deleteProject(prono);
    }
}
