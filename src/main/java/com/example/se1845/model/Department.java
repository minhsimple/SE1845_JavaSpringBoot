package com.example.se1845.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

    @Id
    private String deptno;

    private String name;
    private String location;

    public Department() {
    }

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    private List<Employee> emps = new ArrayList<>();

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    private List<Project> pros = new ArrayList<>();

    public List<Project> getPros() {
        return pros;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public String getDeptno() {
        return deptno;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setDeptno(String DeptNo) {
        this.deptno = DeptNo;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public void setEmps( List<Employee> emps) {
        this.emps = emps;
    }

    public void setPros( List<Project> pros) {
        this.pros = pros;
    }

}
