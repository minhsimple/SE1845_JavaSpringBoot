package com.example.se1845.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.se1845.model.Project;

public interface ProjectService {
    public ResponseEntity<Object> createProject(Project pro);

    public ResponseEntity<Object> updateProject(String proNo, Project pro);

    public Optional<Project> getProjectById(String proNo);

    public Iterable<Project> getAllProject();

    public ResponseEntity<Object> deleteProject(String proNo);
}
