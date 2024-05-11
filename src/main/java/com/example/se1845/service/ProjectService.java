package com.example.se1845.service;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.ProjectDTO;

public interface ProjectService {
    public ResponseEntity<Object> createProject(ProjectDTO proDto);

    public ResponseEntity<Object> updateProject(String prono, ProjectDTO proDto);

    public ResponseEntity<Object> getProjectById(String prono);

    public ResponseEntity<Object> getAllProject();

    public ResponseEntity<Object> deleteProject(String prono);
}
