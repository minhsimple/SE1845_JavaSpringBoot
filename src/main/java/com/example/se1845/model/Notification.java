package com.example.se1845.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @Column(name = "NotifyID")
    private String notifyid;

    @Column(name = "Title")
    private String title;

    @Column(name = "Detail")
    private String detail;

    @Column(name = "Start")
    private String start;

    @Column(name = "End")
    private String end;

    @ManyToOne
    @JoinColumn(name = "SSN")
    @JsonBackReference
    private Employee employee;

}
