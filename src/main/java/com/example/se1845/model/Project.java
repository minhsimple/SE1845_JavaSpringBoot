package com.example.se1845.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

    @Id
    @Column(name = "ProNo")
    private String proNo;

    @Column(name = "Name")
    private String name;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "EndDate")
    private String endDate;

    public Project() {
    }

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    Set<EmpWorkOnPro> ewps;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;

    public Set<EmpWorkOnPro> getEwps() {
        return ewps;
    }

    public Department getDept() {
        return dept;
    }

    public String getProNo() {
        return proNo;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setProNo(String ProNo) {
        this.proNo = ProNo;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setStartDate(String StartDate) {
        this.startDate = StartDate;
    }

    public void setEndDate(String EndDate) {
        this.endDate = EndDate;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setEwps(Set<EmpWorkOnPro> ewps) {
        this.ewps = ewps;
    }

}
