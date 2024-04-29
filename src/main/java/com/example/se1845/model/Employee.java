package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "SSN")
    private String ssn;

    @Column(name = "FName")
    private String fname;

    @Column(name = "LName")
    private String lname;

    @Column(name = "Address")
    private String address;

    @Column(name = "Salary")
    private double salary;

    @Column(name = "Sex")
    private boolean sex;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<EmpWorkOnPro> ewps;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<EmpRelationDep> erds;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    @JsonBackReference
    private Role role;
}
