package com.example.se1845.model;

import com.example.se1845.model.CompositeKey.EmpWorkOnProKey;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Emp_WorkOn_Pro")
public class EmpWorkOnPro {

    @EmbeddedId
    private EmpWorkOnProKey id;

    @ManyToOne
    @MapsId("ssn")
    @JoinColumn(name = "SSN")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @MapsId("proNo")
    @JoinColumn(name = "ProNo")
    @JsonBackReference
    private Project project;

    private String position;

    @Column(name = "HourPerDay")
    private float hourPerDay;
}
