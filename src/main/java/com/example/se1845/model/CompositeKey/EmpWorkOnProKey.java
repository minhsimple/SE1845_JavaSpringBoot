package com.example.se1845.model.CompositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpWorkOnProKey implements Serializable {

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "ProNo")
    private String proNo;

    public EmpWorkOnProKey() {

    }

    public EmpWorkOnProKey(String ssn, String proNo) {
        this.ssn = ssn;
        this.proNo = proNo;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String SSN) {
        this.ssn = SSN;
    }

    public String getProNo() {
        return proNo;
    }

    public void setProNo(String ProNo) {
        this.proNo = ProNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        result = prime * result + ((proNo == null) ? 0 : proNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        EmpWorkOnProKey other = (EmpWorkOnProKey) obj;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        if (proNo == null) {
            if (other.proNo != null)
                return false;
        } else if (!proNo.equals(other.proNo))
            return false;
        return true;
    }
}
