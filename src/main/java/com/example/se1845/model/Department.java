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
    private String DeptNo;

    private String Name;
    private String Location;

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

    public String getDeptNo() {
        return DeptNo;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void setDeptNo(String DeptNo) {
        this.DeptNo = DeptNo;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setPros(List<Project> pros) {
        this.pros = pros;
    }

}
