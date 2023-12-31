package org.softuni.carpartsshop.models.dtos.forLogic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AddCarDto(
        @NotNull
        String brandName,
        @NotNull @Size(min = 1, max = 30, message = "The name of the model must be between 1 and 30 symbols!")
        String modelName,
        @NotNull @Size(min = 1, max = 40, message = "The name of the submodel must be between 1 and 40 symbols!")
        String submodelName,
        @NotNull String submodelImage,
        @NotNull @Size(min = 1, max = 20, message = "The engine must be between 1 and 20 symbols!")
        String engine,
        @NotNull String engineCode,
        @NotNull @Positive Integer horsePower,
        @NotNull String year,
        @NotNull
        String fuel
) {

    public static AddCarDto construct() {
        return new AddCarDto(null, null, null, null, null,
                null, null, null, null);
    }
}
