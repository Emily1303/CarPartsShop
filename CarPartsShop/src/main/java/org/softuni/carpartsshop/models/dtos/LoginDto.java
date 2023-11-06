package org.softuni.carpartsshop.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull(message = "Email is required!") @Email String email,
                       @NotNull(message = "Password is required!") String password) {

    public static LoginDto construct() {
        return new LoginDto(null, null);
    }

}
