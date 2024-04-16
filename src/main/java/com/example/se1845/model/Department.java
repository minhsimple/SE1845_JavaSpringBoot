package com.example.se1845.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    private String DeptNo;

    private String Name;
    private String Location;

    public Department() {
    }

    public String getDeptNo() {
        return DeptNo;
    }

    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

}
