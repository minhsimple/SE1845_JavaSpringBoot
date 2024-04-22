package com.example.se1845.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    public EmployeeDTO() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
}
