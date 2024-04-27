package com.example.se1845.model.CompositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpRelationDepKey implements Serializable {

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "DepID")
    private String depId;
}
