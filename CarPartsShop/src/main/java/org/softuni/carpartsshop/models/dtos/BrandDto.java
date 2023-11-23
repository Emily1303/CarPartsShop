package org.softuni.carpartsshop.models.dtos;

import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;

import java.util.Set;
import java.util.UUID;

public class BrandDto {

    private String brandName;

    private String brandImage;

    private UUID uuid;

    private Set<Model> models;

    public BrandDto(Brand brand) {
        super();
        brandName = brand.getBrandName();
        brandImage = brand.getBrandImage();
        uuid = brand.getUuid();
        models = brand.getModels();
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

}
