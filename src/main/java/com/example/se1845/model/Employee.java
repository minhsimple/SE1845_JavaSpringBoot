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
    private String SSN;

    private String FName, LName, Address;
    private double Salary;
    private boolean sex;

    public Employee() {
    }

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<Emp_WorkOn_Pro> ewps;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<Emp_Relation_Dep> erds;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;

    public Set<Emp_Relation_Dep> getErds() {
        return erds;
    }

    public Set<Emp_WorkOn_Pro> getEwps() {
        return ewps;
    }

    public Department getDept() {
        return dept;
    }

    public String getSSN() {
        return SSN;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public String getAddress() {
        return Address;
    }

    public double getSalary() {
        return Salary;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setEwps(Set<Emp_WorkOn_Pro> ewps) {
        this.ewps = ewps;
    }

    public void setErds(Set<Emp_Relation_Dep> erds) {
        this.erds = erds;
    }
}
