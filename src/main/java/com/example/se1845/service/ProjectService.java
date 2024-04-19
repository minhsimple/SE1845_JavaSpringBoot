package com.example.se1845.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.ProjectDTO;

public interface ProjectService {
    public ResponseEntity<Object> createProject(ProjectDTO proDto);

    public ResponseEntity<Object> updateProject(String prono, ProjectDTO proDto);

    public ResponseEntity<Object> getProjectById(String prono);

    public List<ProjectDTO> getAllProject();

    public ResponseEntity<Object> deleteProject(String prono);
}
