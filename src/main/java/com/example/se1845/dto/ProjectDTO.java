package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    public ProjectDTO() {
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }
}
