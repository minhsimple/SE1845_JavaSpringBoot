package com.example.se1845.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {

    @Id
    private String ProNo;

    private String Name;
    private String StartDate;
    private String EndDate;

    public Project() {
    }

    @ManyToMany(mappedBy = "pros")
    private List<Employee> emps = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    private Department dept;

    public Department getDept() {
        return dept;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public String getProNo() {
        return ProNo;
    }

    public String getName() {
        return Name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void setProNo(String ProNo) {
        this.ProNo = ProNo;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
