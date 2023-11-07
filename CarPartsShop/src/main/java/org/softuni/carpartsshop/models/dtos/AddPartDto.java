package org.softuni.carpartsshop.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddPartDto(
        @NotNull @Size(min = 3, max = 30, message = "The name of the brand must be between 3 and 30 symbols!")
        String brandName,
        @NotNull @Size(min = 3, max = 30, message = "The name of the model must be between 3 and 30 symbols!")
        String modelName,
        @NotNull @Size(min = 1, max = 30, message = "The name of the submodel must be between 3 and 30 symbols!")
        String submodelName,
        @NotNull @Size(min = 3, max = 10, message = "The engine must be between 3 and 10 symbols!")
        String engine,
        @NotNull String engineCode,
        @NotNull @Positive Integer horsePower,
        @NotNull String year,
        @NotNull @Size(min = 3, max = 10, message = "The fuel must be between 3 and 10 symbols!")
        String fuel,
        @NotNull @Size(min = 3, max = 30, message = "The name of the part must be between 3 and 30 symbols!")
        String partName,
        @NotNull @Size(min = 3, max = 30, message = "The group's name must be between 3 and 30 symbols!")
        String groupName,
        @NotNull @Size(min = 3, max = 30, message = "The kind's name must be between 3 and 30 symbols!")
        String kind,
        @NotNull String manufacturer,
        @NotNull String serialNumber,
        @NotNull @Positive BigDecimal price
) {

    public static AddPartDto construct() {
        return new AddPartDto(null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null);
    }

}
