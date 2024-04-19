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
import com.example.se1845.repository.DepartmentRepository;
import com.example.se1845.repository.ProjectRepository;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    ProjectConverter projectConverter;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<Object> createProject(ProjectDTO proDto) {
        Project pro = projectConverter.toProject(proDto);
        pro.setDept(departmentRepository.findById(proDto.getDeptno()).get());
        projectRepository.save(pro);
        return new ResponseEntity<>(proDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateProject(String prono, ProjectDTO proDto) {
        if (projectRepository.existsById(prono)) {
            Project pro = projectRepository.findById(prono).get();
            pro = projectConverter.toProject(proDto, pro);
            pro.setDept(departmentRepository.findById(proDto.getDeptno()).get());
            projectRepository.save(pro);
            return new ResponseEntity<>(proDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getProjectById(String prono) {
        Optional<Project> proOptional = projectRepository.findById(prono);
        if (!proOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Project pro = proOptional.get();
        String deptno = pro.getDept().getDeptno();
        ProjectDTO proDto = projectConverter.toProjectDTO(pro);
        proDto.setDeptno(deptno);
        return new ResponseEntity<>(proDto, HttpStatus.OK);
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        Iterable<Project> proList = projectRepository.findAll();
        List<ProjectDTO> proDtoList = new ArrayList<>();
        for (Project pro : proList) {
            String deptno = pro.getDept().getDeptno();
            ProjectDTO proDto = projectConverter.toProjectDTO(pro);
            proDto.setDeptno(deptno);
            proDtoList.add(proDto);
        }
        return proDtoList;
    }

    @Override
    public ResponseEntity<Object> deleteProject(String proNo) {
        projectRepository.deleteById(proNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
