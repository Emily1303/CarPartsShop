package org.softuni.carpartsshop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component(value = "currentUser")
@SessionScope
public class CurrentUser {

    private String firstName;

    private String lastName;

    private boolean isLogged;

    public CurrentUser() {

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

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();

        if (firstName != null) {
            sb.append(firstName);
        }

        if (lastName != null) {
            sb.append(" ");
        }

        sb.append(lastName);

        return sb.toString();
    }

    public void logout() {
        setFirstName(null);
        setLastName(null);
        setLogged(false);
    }

}
