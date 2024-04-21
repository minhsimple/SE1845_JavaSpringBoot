package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    public DependenceDTO() {
    }

    public String getDepId() {
        return depId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
