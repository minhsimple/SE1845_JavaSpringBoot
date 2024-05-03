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
public class Role {

    @Id
    @Column(name = "RoleId")
    private String roleid;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private List<Employee> emps = new ArrayList<>();
}
