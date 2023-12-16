package org.softuni.carpartsshop.models.dtos.forTemplates;

import java.util.ArrayList;
import java.util.List;

public class AllPartDtos {

    private List<PartDto> partDtoList;

    public AllPartDtos(List<PartDto> partDtoList) {
        this.partDtoList = new ArrayList<>();
    }

    public AllPartDtos() {
        this.partDtoList = new ArrayList<>();
    }

    public List<PartDto> getPartDtoList() {
        return partDtoList;
    }

    public void setPartDtoList(List<PartDto> partDtoList) {
        this.partDtoList = partDtoList;
    }

}
