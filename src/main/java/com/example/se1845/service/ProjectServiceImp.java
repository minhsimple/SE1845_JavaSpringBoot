package com.example.se1845.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.model.Project;
import com.example.se1845.repository.ProjectRepository;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ResponseEntity<Object> createProject(Project pro) {
        return new ResponseEntity<>(projectRepository.save(pro), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateProject(String proNo, Project pro) {
        return (projectRepository.existsById(proNo)) ? new ResponseEntity<>(projectRepository.save(pro), HttpStatus.OK)
                : new ResponseEntity<>(projectRepository.save(pro), HttpStatus.CREATED);
    }

    @Override
    public Optional<Project> getProjectById(String proNo) {
        return projectRepository.findById(proNo);
    }

    @Override
    public Iterable<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> deleteProject(String proNo) {
        projectRepository.deleteById(proNo);
        return new ResponseEntity<>("Project deleted", HttpStatus.OK);
    }
}
