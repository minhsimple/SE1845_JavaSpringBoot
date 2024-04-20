package com.example.se1845.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.se1845.dto.DependenceDTO;
import com.example.se1845.model.Dependence;

@Component
public class DependenceConverter {
    private ModelMapper modelMapper;

    public DependenceConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(DependenceDTO.class, Dependence.class)
                .addMappings(mapper -> {
                    mapper.skip(Dependence::setErds);
                });
    }

    public Dependence toDependence(DependenceDTO dependenceDto) {
        return modelMapper.map(dependenceDto, Dependence.class);
    }

    public DependenceDTO toDependenceDTO(Dependence dependence) {
        return modelMapper.map(dependence, DependenceDTO.class);
    }
}
