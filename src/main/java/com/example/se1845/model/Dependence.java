package com.example.se1845.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dependence {

    @Id
    private String DepID;

    private String Name;
    private String DOB;

    @OneToMany(mappedBy = "dependence")
    private Set<Emp_Relation_Dep> erds;

    public Dependence() {
    }

    public Set<Emp_Relation_Dep> getErds() {
        return erds;
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

    public void setDepID(String DepID) {
        this.DepID = DepID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setErds(Set<Emp_Relation_Dep> erds) {
        this.erds = erds;
    }

}
