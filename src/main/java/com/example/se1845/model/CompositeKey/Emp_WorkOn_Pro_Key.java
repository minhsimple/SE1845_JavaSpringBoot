package com.example.se1845.model.CompositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Emp_WorkOn_Pro_Key implements Serializable {
    @Column(name = "SSN")
    private String SSN;

    @Column(name = "ProNo")
    private String ProNo;

    public Emp_WorkOn_Pro_Key() {

    }

    public Emp_WorkOn_Pro_Key(String SSN, String ProNo) {
        this.SSN = SSN;
        this.ProNo = ProNo;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getProNo() {
        return ProNo;
    }

    public void setProNo(String ProNo) {
        this.ProNo = ProNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((SSN == null) ? 0 : SSN.hashCode());
        result = prime * result + ((ProNo == null) ? 0 : ProNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Emp_WorkOn_Pro_Key other = (Emp_WorkOn_Pro_Key) obj;
        if (SSN == null) {
            if (other.SSN != null)
                return false;
        } else if (!SSN.equals(other.SSN))
            return false;
        if (ProNo == null) {
            if (other.ProNo != null)
                return false;
        } else if (!ProNo.equals(other.ProNo))
            return false;
        return true;
    }
}
