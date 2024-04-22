package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenceDTO {

    @NotNull(message = "dependence id is required")
    @NotBlank(message = "dependence id is required")
    private String depId;

    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "date of birth is required")
    @NotBlank(message = "date of birth is required")
    private String dob;
}
