package com.example.se1845.model;

import com.example.se1845.model.CompositeKey.Emp_Relation_Dep_Key;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Emp_Relation_Dep {

    @EmbeddedId
    private Emp_Relation_Dep_Key id;

    @ManyToOne
    @MapsId("SSN")
    @JoinColumn(name = "SSN")
    Employee employee;

    @ManyToOne
    @MapsId("DepID")
    @JoinColumn(name = "DepID")
    Dependence dependence;

    private String Relationship;

    public Emp_Relation_Dep() {
    }

    public Emp_Relation_Dep(Emp_Relation_Dep_Key id, Employee employee, Dependence dependence, String relationship) {
        this.id = id;
        this.employee = employee;
        this.dependence = dependence;
        this.Relationship = relationship;
    }

    public Emp_Relation_Dep_Key getId() {
        return id;
    }

    public void setId(Emp_Relation_Dep_Key id) {
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
