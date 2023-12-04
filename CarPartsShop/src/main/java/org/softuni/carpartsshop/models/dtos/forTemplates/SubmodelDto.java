package org.softuni.carpartsshop.models.dtos.forTemplates;

import org.softuni.carpartsshop.models.entities.Part;

import java.util.List;
import java.util.UUID;

public class SubmodelDto {

    private String submodelName;

    private String submodelImage;

    private String engine;

    private String engineCode;

    private Integer horsePower;

    private String year;

    private String fuel;

    private List<Part> parts;

    private UUID uuid;

    public SubmodelDto() {

    }

    public String getSubmodelName() {
        return submodelName;
    }

    public void setSubmodelName(String submodelName) {
        this.submodelName = submodelName;
    }

    public String getSubmodelImage() {
        return submodelImage;
    }

    public void setSubmodelImage(String submodelImage) {
        this.submodelImage = submodelImage;
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
