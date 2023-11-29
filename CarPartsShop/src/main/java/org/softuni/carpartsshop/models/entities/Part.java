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
    @Size(min = 3, max = 60, message = "The name must be between 3 and 60 symbols!")
    @Column(name = "part_name")
    private String partName;

    @NotNull
    @Size(min = 1, max = 60, message = "The group's name must be between 1 and 60 symbols!")
    @Column(name = "group_name")
    private String groupName;

    @NotNull
    @Column
    private String kind;

    @NotNull
    @Column
    private String manufacturer;

//    validation - valid serial number
    @NotNull
    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @NotNull
    @Positive
    @Column
    private BigDecimal price;

    @NotNull
    @Column(name = "is_available")
    private Boolean isAvailable;

    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID uuid;

    @NotNull
    @Column(name = "part_image")
    private String partImage;

    @ManyToMany(targetEntity = Submodel.class, fetch = FetchType.EAGER)
    private List<Submodel> submodel;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    private List<User> boughtBy;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getPartImage() {
        return partImage;
    }

    public void setPartImage(String partImage) {
        this.partImage = partImage;
    }

    public List<Submodel> getSubmodel() {
        return submodel;
    }

    public void setSubmodel(List<Submodel> submodel) {
        this.submodel = submodel;
    }

    public List<User> getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(List<User> boughtBy) {
        this.boughtBy = boughtBy;
    }
}
