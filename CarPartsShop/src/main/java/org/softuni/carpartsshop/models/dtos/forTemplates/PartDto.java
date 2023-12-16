package org.softuni.carpartsshop.models.dtos.forTemplates;

import java.math.BigDecimal;

public class PartDto {

    private String partName;

    private BigDecimal price;

    public PartDto() {

    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
