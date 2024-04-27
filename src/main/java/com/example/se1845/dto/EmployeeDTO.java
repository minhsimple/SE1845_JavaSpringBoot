package com.example.se1845.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotNull(message = "ssn is required")
    @NotBlank(message = "ssn is required")
    private String ssn;

    @NotNull(message = "firstname is required")
    @NotBlank(message = "firstname is required")
    private String fname;

    @NotNull(message = "lastname is required")
    @NotBlank(message = "lastname is required")
    private String lname;

    @NotNull(message = "address is required")
    @NotBlank(message = "address is required")
    private String address;

    @Min(value = 1, message = "salary must be greater than 0")
    private double salary;

    private boolean sex;

    @NotNull(message = "department number is required")
    @NotBlank(message = "department number is required")
    private String deptNo;
}
