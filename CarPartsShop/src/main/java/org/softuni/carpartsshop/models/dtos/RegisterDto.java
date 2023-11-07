package org.softuni.carpartsshop.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.softuni.carpartsshop.validations.*;

@MatchPasswords(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "The password you entered does not match!"
)
public record RegisterDto(
        @NotNull
        @Size(min = 3, max = 30, message = "The first name must be between 3 and 30 symbols!")
        String firstName,
        @NotNull
        @Size(min = 3, max = 30, message = "The last name must be between 3 and 30 symbols!")
        String lastName,
        @NotNull @Email @UniqueEmail String email,
        @NotNull @ValidLength @ContainsUpperCase
        @ContainsLowerCase @ContainsDigit
        @ContainsSpecialSymbol @ContainsWhitespace String password,
        @NotNull String confirmPassword) {

    public static RegisterDto construct() {
        return new RegisterDto(null, null, null, null, null);
    }

}
