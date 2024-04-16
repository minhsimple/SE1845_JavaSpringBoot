package com.example.se1845.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private String SSN;

    private String FName, LName, Address;
    private double Salary;
    private boolean sex;

    public Employee() {
    }

    public String getSSN() {
        return SSN;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public String getAddress() {
        return Address;
    }

    public double getSalary() {
        return Salary;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

}
