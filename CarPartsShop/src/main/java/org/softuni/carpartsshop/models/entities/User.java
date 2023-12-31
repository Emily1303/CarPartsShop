package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 30, message = "The first name must be between 3 and 30 symbols!")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30, message = "The last name must be between 3 and 30 symbols!")
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Column
    private String password;

    @NotNull
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @ManyToMany(targetEntity = Part.class, mappedBy = "boughtBy", fetch = FetchType.EAGER)
    private List<Part> boughtParts;

    public User() {
        this.roles = new ArrayList<>();
        this.boughtParts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public List<Part> getBoughtParts() {
        return boughtParts;
    }

    public void setBoughtParts(List<Part> boughtParts) {
        this.boughtParts = boughtParts;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
