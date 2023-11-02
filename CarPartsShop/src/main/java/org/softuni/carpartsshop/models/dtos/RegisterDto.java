package org.softuni.carpartsshop.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterDto(
        @Size(min = 3, max = 30, message = "The first name must be between 3 and 30 symbols!")
        @NotNull String firstName,
        @Size(min = 3, max = 30, message = "The last name must be between 3 and 30 symbols!")
        @NotNull String lastName,
        @NotNull @Email String email,
        @NotNull String password,
        @NotNull String confirmPassword) {

    public static RegisterDto construct() {
        return new RegisterDto(null, null, null, null, null);
    }

}
