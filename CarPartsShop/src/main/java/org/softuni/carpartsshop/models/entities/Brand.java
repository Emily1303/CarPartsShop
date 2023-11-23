package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "brands")
@NamedEntityGraph(
        name = "brandWithModels",
        attributeNodes = @NamedAttributeNode("models")
)
public class Brand extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 20, message = "The brand's name must be between 2 and 20 symbols!")
    @Column(name = "brand_name", unique = true)
    private String brandName;

    @NotNull
    @Column(name = "brand_image")
    private String brandImage;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Model> models;

    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID uuid;

    public Brand() {
        this.models = new HashSet<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
