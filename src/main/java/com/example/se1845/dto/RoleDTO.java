package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    @NotNull(message = "roleid is required")
    @NotBlank(message = "roleid is required")
    private String roleid;

    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
}
