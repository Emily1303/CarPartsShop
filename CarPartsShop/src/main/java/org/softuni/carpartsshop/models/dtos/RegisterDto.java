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
        @Size(min = 3, max = 30, message = "The first name must be between 3 and 30 symbols!")
        @NotNull(message = "First name is required!") String firstName,
        @Size(min = 3, max = 30, message = "The last name must be between 3 and 30 symbols!")
        @NotNull(message = "Last name is required!") String lastName,
        @NotNull(message = "Email is required!") @Email @UniqueEmail String email,
        @NotNull(message = "Password is required!") @ValidLength @ContainsUpperCase
        @ContainsLowerCase @ContainsDigit
        @ContainsSpecialSymbol @ContainsWhitespace String password,
        @NotNull(message = "Password is required!") String confirmPassword) {

    public static RegisterDto construct() {
        return new RegisterDto(null, null, null, null, null);
    }

}
