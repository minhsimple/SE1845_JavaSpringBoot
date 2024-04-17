package com.example.se1845.model.CompositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpRelationDepKey implements Serializable {

    @Column(name = "SSN")
    private String SSN;

    @Column(name = "DepID")
    private String DepID;

    public EmpRelationDepKey() {
    }

    public EmpRelationDepKey(String SSN, String DepID) {
        this.SSN = SSN;
        this.DepID = DepID;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getDepID() {
        return DepID;
    }

    public void setDepID(String DepID) {
        this.DepID = DepID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((SSN == null) ? 0 : SSN.hashCode());
        result = prime * result + ((DepID == null) ? 0 : DepID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        EmpRelationDepKey other = (EmpRelationDepKey) obj;
        if (SSN == null) {
            if (other.SSN != null)
                return false;
        } else if (!SSN.equals(other.SSN))
            return false;
        if (DepID == null) {
            if (other.DepID != null)
                return false;
        } else if (!DepID.equals(other.DepID))
            return false;
        return true;
    }
}
