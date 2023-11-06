package org.softuni.carpartsshop.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AddPartDto(
        @Size(min = 3, max = 30, message = "The name of the brand must be between 3 and 30 symbols!")
        @NotNull String brandName,
        @Size(min = 3, max = 30, message = "The name of the model must be between 3 and 30 symbols!")
        @NotNull String modelName,
        @Size(min = 3, max = 30, message = "The name of the submodel must be between 3 and 30 symbols!")
        @NotNull String submodelName,
        @Size(min = 3, max = 10, message = "The engine must be between 3 and 10 symbols!")
        @NotNull String engine,
        @NotNull @Positive Integer horsePower,
        @NotNull String year,
        @Size(min = 3, max = 10, message = "The fuel must be between 3 and 10 symbols!")
        @NotNull String fuel,
        @Size(min = 3, max = 30, message = "The name of the part must be between 3 and 30 symbols!")
        @NotNull String partName
) {

    public static AddPartDto construct() {
        return new AddPartDto(null, null, null,
                null, null, null, null, null);
    }

}
