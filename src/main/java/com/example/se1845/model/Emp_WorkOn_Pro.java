package com.example.se1845.model;

import com.example.se1845.model.CompositeKey.Emp_WorkOn_Pro_Key;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Emp_WorkOn_Pro {
    @EmbeddedId
    private Emp_WorkOn_Pro_Key id;

    @ManyToOne
    @MapsId("SSN")
    @JoinColumn(name = "SSN")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @MapsId("ProNo")
    @JoinColumn(name = "ProNo")
    @JsonBackReference
    private Project project;

    private String Position;
    private float HourPerDay;

    public Emp_WorkOn_Pro(Emp_WorkOn_Pro_Key id, Employee employee, Project project, String position,
            float hourPerDay) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.Position = position;
        this.HourPerDay = hourPerDay;
    }

    public Emp_WorkOn_Pro() {

    }

    public Emp_WorkOn_Pro_Key getId() {
        return id;
    }

    public void setId(Emp_WorkOn_Pro_Key id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public float getHourPerDay() {
        return HourPerDay;
    }

    public void setHourPerDay(float hourPerDay) {
        HourPerDay = hourPerDay;
    }

}
