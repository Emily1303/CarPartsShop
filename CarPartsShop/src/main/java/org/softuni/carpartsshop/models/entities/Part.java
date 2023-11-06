package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 30, message = "The name must be between 3 and 30 symbols!")
    @Column(name = "part_name")
    private String partName;

    @NotNull
    @Column
    private String kind;

    @NotNull
    @Column
    private String manufacturer;

    @NotNull
    @Positive
    @Column
    private BigDecimal price;

    @NotNull
    @Column(name = "is_available")
    private Boolean isAvailable;

    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID uuid;

    @ManyToMany(mappedBy = "parts")
    private List<Submodel> submodel;

    public Part() {
        this.submodel = new ArrayList<>();
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Submodel> getSubmodel() {
        return submodel;
    }

    public void setSubmodel(List<Submodel> submodel) {
        this.submodel = submodel;
    }

}
