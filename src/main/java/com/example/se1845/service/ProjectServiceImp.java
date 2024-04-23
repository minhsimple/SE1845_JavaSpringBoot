package com.example.se1845.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.converter.ProjectConverter;
import com.example.se1845.dto.ProjectDTO;
import com.example.se1845.model.Project;
import com.example.se1845.repository.ProjectRepository;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    ProjectConverter projectConverter;

    @Override
    public ResponseEntity<Object> createProject(ProjectDTO proDto) {
        Project pro = projectConverter.toProject(proDto);
        projectRepository.save(pro);
        return new ResponseEntity<>(proDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateProject(String prono, ProjectDTO proDto) {
        if (projectRepository.existsById(prono)) {
            Project pro = projectConverter.toProject(proDto);
            projectRepository.save(pro);
            return new ResponseEntity<>(proDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ProjectDTO getProjectById(String prono) {
        Optional<Project> proOptional = projectRepository.findById(prono);
        if (!proOptional.isPresent()) {
            return null;
        }
        Project pro = proOptional.get();
        ProjectDTO proDto = projectConverter.toProjectDTO(pro);
        return proDto;
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        Iterable<Project> proList = projectRepository.findAll();
        List<ProjectDTO> proDtoList = new ArrayList<>();
        for (Project pro : proList) {
            ProjectDTO proDto = projectConverter.toProjectDTO(pro);
            proDtoList.add(proDto);
        }
        return proDtoList;
    }

    @Override
    public ResponseEntity<Object> deleteProject(String proNo) {
        if (projectRepository.existsById(proNo)) {
            projectRepository.deleteById(proNo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
