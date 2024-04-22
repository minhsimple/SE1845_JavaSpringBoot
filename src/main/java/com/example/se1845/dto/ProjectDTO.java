package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    @NotNull(message = "project number is required")
    @NotBlank(message = "project number is required")
    private String prono;

    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "startdate is required")
    @NotBlank(message = "startdate is required")
    private String startDate;

    @NotNull(message = "enddate is required")
    @NotBlank(message = "enddate is required")
    private String endDate;

    @NotNull(message = "department number is required")
    @NotBlank(message = "department number is required")
    private String deptno;
}
