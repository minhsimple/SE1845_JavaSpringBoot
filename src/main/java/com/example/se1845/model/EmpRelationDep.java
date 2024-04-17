package com.example.se1845.model;

import com.example.se1845.model.CompositeKey.EmpRelationDepKey;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emp_Relation_Dep")
public class EmpRelationDep {

    @EmbeddedId
    private EmpRelationDepKey id;

    @ManyToOne
    @MapsId("SSN")
    @JoinColumn(name = "SSN")
    @JsonBackReference
    Employee employee;

    @ManyToOne
    @MapsId("DepID")
    @JoinColumn(name = "DepID")
    @JsonBackReference
    Dependence dependence;

    private String Relationship;

    public EmpRelationDep() {
    }

    public EmpRelationDep(EmpRelationDepKey id, Employee employee, Dependence dependence, String relationship) {
        this.id = id;
        this.employee = employee;
        this.dependence = dependence;
        this.Relationship = relationship;
    }

    public EmpRelationDepKey getId() {
        return id;
    }

    public void setId(EmpRelationDepKey id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Dependence getDependence() {
        return dependence;
    }

    public void setDependence(Dependence dependence) {
        this.dependence = dependence;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String relationship) {
        this.Relationship = relationship;
    }

}