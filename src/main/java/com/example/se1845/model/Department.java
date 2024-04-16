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

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setDeptNo(String DeptNo) {
        this.DeptNo = DeptNo;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

}
