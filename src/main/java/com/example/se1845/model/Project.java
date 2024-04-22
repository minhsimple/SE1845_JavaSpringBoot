package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name = "ProNo")
    private String prono;

    @Column(name = "Name")
    private String name;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "EndDate")
    private String endDate;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    Set<EmpWorkOnPro> ewps;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;
}
