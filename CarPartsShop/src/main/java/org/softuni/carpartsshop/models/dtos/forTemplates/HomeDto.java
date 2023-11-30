package org.softuni.carpartsshop.models.dtos.forTemplates;

import java.util.List;
import java.util.Set;

public class HomeDto {

    private Set<BrandDto> brandDtoList;

    private List<SubmodelDto> submodelDtoList;

    public HomeDto(Set<BrandDto> brandDtoList) {
        this.brandDtoList = brandDtoList;
    }

    public HomeDto(List<SubmodelDto> submodelDtoList) {
        this.submodelDtoList = submodelDtoList;
    }

    public Set<BrandDto> getBrandDtoList() {
        return brandDtoList;
    }

    public void setBrandDtoList(Set<BrandDto> brandDtoList) {
        this.brandDtoList = brandDtoList;
    }

    public List<SubmodelDto> getSubmodelDtoList() {
        return submodelDtoList;
    }

    public void setSubmodelDtoList(List<SubmodelDto> submodelDtoList) {
        this.submodelDtoList = submodelDtoList;
    }

}
