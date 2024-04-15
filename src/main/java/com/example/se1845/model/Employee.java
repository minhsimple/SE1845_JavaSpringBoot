package com.example.se1845.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private String SSN;

    private String FName, LName, Address, DeptNo;
    private double Salary;
    private boolean sex;

    public Employee(String SSN, String FName, String LName, String Address, double Salary, boolean Sex, String DeptNo) {
        this.SSN = SSN;
        this.FName = FName;
        this.LName = LName;
        this.Address = Address;
        this.DeptNo = DeptNo;
        this.Salary = Salary;
        this.sex = Sex;
    }

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

    public String getDeptNo() {
        return DeptNo;
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

    public void setDeptNo(String DeptNo) {
        this.DeptNo = DeptNo;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" + "SSN=" + SSN + ", FName=" + FName + ", LName=" + LName + ", Address=" + Address
                + ", DeptNo=" + DeptNo + ", Salary=" + Salary + ", sex=" + sex
                + '}';
    }

}
