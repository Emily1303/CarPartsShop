package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 20, message = "The model's name must be between 3 and 20 symbols!")
    @Column(name = "model_name", unique = true)
    private String modelName;

    @ManyToOne
    private Brand brand;

    public Model() {

    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
