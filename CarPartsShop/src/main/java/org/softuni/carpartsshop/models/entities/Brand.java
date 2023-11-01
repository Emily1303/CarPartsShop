package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 20, message = "The brand's name must be between 3 and 20 symbols!")
    @Column(name = "brand_name", unique = true)
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Set<Model> models;

    public Brand() {
        this.models = new HashSet<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

}
