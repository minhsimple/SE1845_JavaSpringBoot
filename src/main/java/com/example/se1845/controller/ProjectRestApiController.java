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

import com.example.se1845.model.Project;
import com.example.se1845.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectRestApiController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public Iterable<Project> getAllProjects() {
        return projectService.getAllProject();
    }

    @GetMapping("/{proNo}")
    public Optional<Project> getProjectById(String proNo) {
        return projectService.getProjectById(proNo);
    }

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody Project pro) {
        return projectService.createProject(pro);
    }

    @PutMapping("/{proNo}")
    public ResponseEntity<Object> updateProject(@PathVariable String proNo, @RequestBody Project pro) {
        return projectService.updateProject(proNo, pro);
    }

    @DeleteMapping("/{proNo}")
    public ResponseEntity<Object> deleteProject(@PathVariable String proNo) {
        return projectService.deleteProject(proNo);
    }
}
