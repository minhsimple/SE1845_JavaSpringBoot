package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dependence {

    @Id
    @Column(name = "DepID")
    private String depId;

    @Column(name = "Name")
    private String name;

    @Column(name = "DOB")
    private String dob;

    @OneToMany(mappedBy = "dependence")
    @JsonManagedReference
    private Set<EmpRelationDep> erds;

    public Dependence() {
    }

    public Set<EmpRelationDep> getErds() {
        return erds;
    }

    public String getDepId() {
        return depId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public void setDepId(String DepID) {
        this.depId = DepID;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setDob(String DOB) {
        this.dob = DOB;
    }

    public void setErds(Set<EmpRelationDep> erds) {
        this.erds = erds;
    }

}
