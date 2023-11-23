package org.softuni.carpartsshop.models.dtos;

import java.util.List;

public class HomeDto {

    private List<BrandDto> brandDtoList;

    public HomeDto(List<BrandDto> brandDtoList) {
        this.brandDtoList = brandDtoList;
    }

    public List<BrandDto> getBrandDtoList() {
        return brandDtoList;
    }

    public void setBrandDtoList(List<BrandDto> brandDtoList) {
        this.brandDtoList = brandDtoList;
    }

}
