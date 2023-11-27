package org.softuni.carpartsshop.models.dtos.forLogic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddBrandDto(
        @NotNull @Size(min = 2, max = 30, message = "The name of the brand must be between 2 and 30 symbols!")
        String nameBrand,
        @NotNull String brandImage) {

    public static AddBrandDto construct() {
        return new AddBrandDto(null, null);
    }

}
