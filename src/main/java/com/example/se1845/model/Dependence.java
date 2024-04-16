package com.example.se1845.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Dependence {

    @Id
    private String DepID;

    private String Name;
    private String DOB;

    public Dependence() {
    }

    @ManyToMany(mappedBy = "deps")
    private List<Employee> emps = new ArrayList<>();

    public List<Employee> getEmps() {
        return emps;
    }

    public String getDepID() {
        return DepID;
    }

    public String getName() {
        return Name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void setDepID(String DepID) {
        this.DepID = DepID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

}
