package com.example.se1845.model;

import com.example.se1845.model.CompositeKey.EmpRelationDepKey;
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
@Table(name = "Emp_Relation_Dep")
public class EmpRelationDep {

    @EmbeddedId
    private EmpRelationDepKey id;

    @ManyToOne
    @MapsId("ssn")
    @JoinColumn(name = "SSN")
    @JsonBackReference
    Employee employee;

    @ManyToOne
    @MapsId("depId")
    @JoinColumn(name = "DepID")
    @JsonBackReference
    Dependence dependence;

    @Column(name = "Relationship")
    private String relationship;
}
