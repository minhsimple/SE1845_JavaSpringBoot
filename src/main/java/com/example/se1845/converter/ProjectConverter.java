package com.example.se1845.converter;

import org.springframework.stereotype.Component;

import com.example.se1845.dto.ProjectDTO;
import com.example.se1845.model.Project;

@Component
public class ProjectConverter {

    public Project toProject(ProjectDTO proDto) {
        Project pro = new Project();
        pro.setProNo(proDto.getProno());
        pro.setName(proDto.getName());
        pro.setStartDate(proDto.getStartDate());
        pro.setEndDate(proDto.getEndDate());

        return pro;
    }

    public ProjectDTO toProjectDTO(Project pro) {
        ProjectDTO proDto = new ProjectDTO();
        proDto.setProno(pro.getProNo());
        proDto.setName(pro.getName());
        proDto.setStartDate(pro.getStartDate());
        proDto.setEndDate(pro.getEndDate());

        return proDto;
    }

    public Project toProject(ProjectDTO proDto, Project pro) {
        pro.setName(proDto.getName());
        pro.setStartDate(proDto.getStartDate());
        pro.setEndDate(proDto.getEndDate());

        return pro;
    }
}
