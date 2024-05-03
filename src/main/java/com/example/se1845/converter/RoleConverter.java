package com.example.se1845.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.se1845.dto.RoleDTO;
import com.example.se1845.model.Role;

@Component
public class RoleConverter {

    private ModelMapper modelMapper;

    public RoleConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(RoleDTO.class, Role.class)
                .addMappings(mapper -> {
                    mapper.skip(Role::setEmps);
                });
    }

    public Role toRole(RoleDTO roleDto) {
        return modelMapper.map(roleDto, Role.class);
    }

    public RoleDTO toRoleDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }
}
