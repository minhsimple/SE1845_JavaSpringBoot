package com.example.se1845.model;

import com.example.se1845.model.CompositeKey.EmpWorkOnProKey;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emp_WorkOn_Pro")
public class EmpWorkOnPro {
    @EmbeddedId
    private EmpWorkOnProKey id;

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

    public EmpWorkOnPro(EmpWorkOnProKey id, Employee employee, Project project, String position,
            float hourPerDay) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.Position = position;
        this.HourPerDay = hourPerDay;
    }

    public EmpWorkOnPro() {

    }

    public EmpWorkOnProKey getId() {
        return id;
    }

    public void setId(EmpWorkOnProKey id) {
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
