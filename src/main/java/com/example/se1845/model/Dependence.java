package com.example.se1845.model;

@Entity
public class Dependence {

    @Id
    private String DepID;

    private String Name;
    private String DOB;

    public Dependence() {
    }

    public String getDepID() {
        return DepID;
    }

    public String getName() {
        return Name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDepID(String DepID) {
        this.DepID = DepID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

}
