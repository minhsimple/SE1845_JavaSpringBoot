package com.example.se1845.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements UserDetails {

    @Id
    @Column(name = "SSN")
    private String ssn;

    @Column(name = "FName")
    private String fname;

    @Column(name = "LName")
    private String lname;

    @Column(name = "Address")
    private String address;

    @Column(name = "Salary")
    private double salary;

    @Column(name = "Sex")
    private boolean sex;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Forgot_password_otp")
    private Integer forgotPasswordOtp;

    @Column(name = "Otp_Expired")
    private Date otpExpired;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<EmpWorkOnPro> ewps;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    Set<EmpRelationDep> erds;

    @ManyToOne
    @JoinColumn(name = "DeptNo")
    @JsonBackReference
    private Department dept;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    @JsonBackReference
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
