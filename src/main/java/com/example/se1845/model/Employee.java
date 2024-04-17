package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Employee {

    @Id
    private String ssn;

    private String fname, lname, address;
    private double salary;
    private boolean sex;

    public Employee() {
    }

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<EmpWorkOnPro> ewps;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<EmpRelationDep> erds;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;

    public Set<EmpRelationDep> getErds() {
        return erds;
    }

    public Set<EmpWorkOnPro> getEwps() {
        return ewps;
    }

    public Department getDept() {
        return dept;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSsn(String SSN) {
        this.ssn = SSN;
    }

    public void setFname(String FName) {
        this.fname = FName;
    }

    public void setLname(String LName) {
        this.lname = LName;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public void setSalary(double Salary) {
        this.salary = Salary;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setEwps(Set<EmpWorkOnPro> ewps) {
        this.ewps = ewps;
    }

    public void setErds(Set<EmpRelationDep> erds) {
        this.erds = erds;
    }
}
