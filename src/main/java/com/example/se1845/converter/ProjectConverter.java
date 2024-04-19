package com.example.se1845.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.se1845.dto.ProjectDTO;
import com.example.se1845.model.Project;

@Component
public class ProjectConverter {
    private ModelMapper modelMapper;

    public ProjectConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Project.class, ProjectDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getDept().getDeptno(), ProjectDTO::setDeptno);
                });

        modelMapper.typeMap(ProjectDTO.class, Project.class)
                .addMappings(mapper -> {
                    mapper.<String>map(ProjectDTO::getDeptno, (dest, value) -> dest.getDept().setDeptno(value));
                    mapper.skip(Project::setEwps);
                });
    }

    public Project toProject(ProjectDTO projectDto) {
        return modelMapper.map(projectDto, Project.class);
    }

    public ProjectDTO toProjectDTO(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }
}
