package com.example.se1845.model;

import java.util.ArrayList;
import java.util.List;

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
public class Department {

    @Id
    @Column(name = "DeptNo")
    private String deptno;

    @Column(name = "Name")
    private String name;

    @Column(name = "Location")
    private String location;

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    private List<Employee> emps = new ArrayList<>();

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    private List<Project> pros = new ArrayList<>();
}
