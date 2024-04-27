package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
