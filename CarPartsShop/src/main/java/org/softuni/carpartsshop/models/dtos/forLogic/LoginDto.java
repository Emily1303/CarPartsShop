package org.softuni.carpartsshop.models.dtos.forLogic;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull @Email String email,
                       @NotNull String password) {

    public static LoginDto construct() {
        return new LoginDto(null, null);
    }

}
