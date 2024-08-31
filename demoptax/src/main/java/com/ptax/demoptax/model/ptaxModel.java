package com.ptax.demoptax.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Entity
public class ptaxModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Full Name cannot be empty")
    private String fullname;

    @NotBlank(message = "Address cannot be empty")
    private String propertyaddress;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number is invalid. It must be exactly 10 digits.")
    @NotBlank(message = "Mobile cannot be empty")
    private String mobile;

    @Past(message = "Date of Birth should be a past date")
    private LocalDate dateOfBirth;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fullname;
    }

    public void setName(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return propertyaddress;
    }

    public void setAddress(String propertyaddress) {
        this.propertyaddress = propertyaddress;
    }

    public String getPhone() {
        return mobile;
    }

    public void setPhone(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
