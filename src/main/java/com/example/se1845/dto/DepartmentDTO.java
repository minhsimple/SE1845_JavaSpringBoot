package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    @NotNull(message = "department number is required")
    @NotBlank(message = "department number is required")
    private String deptno;

    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "location is required")
    @NotBlank(message = "location is required")
    private String location;
}
