package org.softuni.carpartsshop.models.dtos.forLogic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddPartDto(
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
                null, null, null);
    }

}
