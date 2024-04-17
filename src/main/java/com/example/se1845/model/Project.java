package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

    @Id
    private String ProNo;

    private String Name;
    private String StartDate;
    private String EndDate;

    public Project() {
    }

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    Set<Emp_WorkOn_Pro> ewps;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;

    public Set<Emp_WorkOn_Pro> getEwps() {
        return ewps;
    }

    public Department getDept() {
        return dept;
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

    public void setEwps(Set<Emp_WorkOn_Pro> ewps) {
        this.ewps = ewps;
    }

}
