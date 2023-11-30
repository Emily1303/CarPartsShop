package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.softuni.carpartsshop.models.enums.FuelsEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "submodels")
@NamedEntityGraph(
        name = "submodelsWithParts",
        attributeNodes = @NamedAttributeNode("parts")
)
public class Submodel extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 40, message = "The model's name must be between 1 and 40 symbols!")
    @Column(name = "submodel_name", unique = true)
    private String submodelName;

    @ManyToOne()
    private Model model;

    @NotNull
    @Column
    private String engine;

//    validation - valid code: with digits, upper case letters, whitespaces and commas
    @NotNull
    @Column(name = "engine_code")
    private String engineCode;

    @NotNull
    @Column(name = "horse_power")
    private Integer horsePower;

    @NotNull
    @Column
    private String year;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private FuelsEnum fuel;

    @NotNull
    @Column(name = "submodel_image")
    private String submodelImage;

    @ManyToMany(targetEntity = Part.class, mappedBy = "submodel", fetch = FetchType.EAGER)
    private List<Part> parts;

    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID uuid;

    public Submodel() {
        this.parts = new ArrayList<>();
    }

    public String getSubmodelName() {
        return submodelName;
    }

    public void setSubmodelName(String subModelName) {
        this.submodelName = subModelName;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public FuelsEnum getFuel() {
        return fuel;
    }

    public void setFuel(FuelsEnum fuel) {
        this.fuel = fuel;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSubmodelImage() {
        return submodelImage;
    }

    public void setSubmodelImage(String submodelImage) {
        this.submodelImage = submodelImage;
    }

}
