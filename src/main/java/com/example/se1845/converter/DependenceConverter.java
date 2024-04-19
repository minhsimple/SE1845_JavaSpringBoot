package com.example.se1845.converter;

import org.springframework.stereotype.Component;

import com.example.se1845.dto.DependenceDTO;
import com.example.se1845.model.Dependence;

@Component
public class DependenceConverter {

    public Dependence toDependence(DependenceDTO dependenceDto) {
        Dependence dependence = new Dependence();
        dependence.setDepId(dependenceDto.getDepId());
        dependence.setName(dependenceDto.getName());
        dependence.setDob(dependenceDto.getDob());

        return dependence;
    }

    public DependenceDTO toDependenceDTO(Dependence dependence) {
        DependenceDTO dependenceDto = new DependenceDTO();
        dependenceDto.setDepId(dependence.getDepId());
        dependenceDto.setName(dependence.getName());
        dependenceDto.setDob(dependence.getDob());

        return dependenceDto;
    }

    public Dependence toDependence(DependenceDTO dependenceDto, Dependence dependence) {
        dependence.setName(dependenceDto.getName());
        dependence.setDob(dependenceDto.getDob());

        return dependence;
    }
}
