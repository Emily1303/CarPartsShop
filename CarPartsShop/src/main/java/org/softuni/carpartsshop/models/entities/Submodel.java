package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "submodels")
public class Submodel extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 20, message = "The model's name must be between 3 and 20 symbols!")
    @Column(name = "submodel_name", unique = true)
    private String submodelName;

    @ManyToOne
    private Model model;

    @NotNull
    @Column
    private String engine;

    @NotNull
    @Column(name = "horse_power", unique = true)
    private Integer horsePower;

    @NotNull
    @Column
    private String year;

    @NotNull
    @Column
    private String fuel;

    @ManyToMany
    private List<Part> parts;

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

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}
