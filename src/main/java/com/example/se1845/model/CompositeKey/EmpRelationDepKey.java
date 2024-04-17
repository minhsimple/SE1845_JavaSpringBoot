package com.example.se1845.model.CompositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpRelationDepKey implements Serializable {

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "DepID")
    private String depId;

    public EmpRelationDepKey() {
    }

    public EmpRelationDepKey(String ssn, String depId) {
        this.ssn = ssn;
        this.depId = depId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String SSN) {
        this.ssn = SSN;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String DepID) {
        this.depId = DepID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        result = prime * result + ((depId == null) ? 0 : depId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        EmpRelationDepKey other = (EmpRelationDepKey) obj;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        if (depId == null) {
            if (other.depId != null)
                return false;
        } else if (!depId.equals(other.depId))
            return false;
        return true;
    }
}
