package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "models")
@NamedEntityGraph(
        name = "modelsWithSubmodels",
        attributeNodes = @NamedAttributeNode("submodels")
)
public class Model extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 20, message = "The model's name must be between 3 and 20 symbols!")
    @Column(name = "model_name", unique = true)
    private String modelName;

    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private Set<Submodel> submodels;

    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID uuid;

    public Model() {
        this.submodels  = new HashSet<>();
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

    public Set<Submodel> getSubmodels() {
        return submodels;
    }

    public void setSubmodels(Set<Submodel> submodels) {
        this.submodels = submodels;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
