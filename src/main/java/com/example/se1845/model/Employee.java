package com.example.se1845.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

    @ManyToMany
    @JoinTable(name = "Emp_Relation_Dep", joinColumns = @JoinColumn(name = "SSN"), inverseJoinColumns = @JoinColumn(name = "DepID"))
    private List<Dependence> deps = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Emp_WorkOn_Pro", joinColumns = @JoinColumn(name = "SSN"), inverseJoinColumns = @JoinColumn(name = "ProNo"))
    private List<Project> pros = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    private Department dept;

    public Department getDept() {
        return dept;
    }

    public List<Project> getPros() {
        return pros;
    }

    public List<Dependence> getDeps() {
        return deps;
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

    public void setDeps(List<Dependence> deps) {
        this.deps = deps;
    }

    public void setPros(List<Project> pros) {
        this.pros = pros;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
