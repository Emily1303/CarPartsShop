package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @NotNull
    @Email
//    TODO:make special validation for unique email (see if the email is in the database or not)
    @Column
    private String email;

    @NotNull
//    TODO:special validation for password (the length, what elements consists of)
    @Column
    private String password;

    public User() {

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

}
