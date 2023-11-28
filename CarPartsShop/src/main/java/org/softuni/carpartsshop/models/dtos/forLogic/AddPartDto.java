package org.softuni.carpartsshop.models.dtos.forLogic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddPartDto(
        @NotNull @Size(min = 1, max = 40, message = "The name of the submodel must be between 3 and 40 symbols!")
        String submodelName,
        @NotNull @Size(min = 3, max = 60, message = "The name of the part must be between 3 and 60 symbols!")
        String partName,
        @NotNull String partImage,
        @NotNull @Size(min = 1, max = 60, message = "The group's name must be between 1 and 60 symbols!")
        String groupName,
        @NotNull @Size(min = 1, max = 60, message = "The kind's name must be between 1 and 60 symbols!")
        String kind,
        @NotNull String manufacturer,
        @NotNull String serialNumber,
        @NotNull @Positive BigDecimal price
) {

    public static AddPartDto construct() {
        return new AddPartDto(null, null, null,
                null, null, null, null, null);
    }

}
