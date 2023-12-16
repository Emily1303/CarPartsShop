package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.AllPartDtos;
import org.softuni.carpartsshop.models.dtos.forTemplates.PartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.repositories.PartRepository;
import org.softuni.carpartsshop.services.PartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }


    @Override
    public Part addPart(AddPartDto addPartDto, Submodel submodel) {

        Part newPart = new Part();
        newPart.setPartName(addPartDto.partName());
        newPart.setGroupName(addPartDto.groupName());
        newPart.setKind(addPartDto.kind());
        newPart.setManufacturer(addPartDto.manufacturer());
        newPart.setSerialNumber(addPartDto.serialNumber());
        newPart.setPrice(addPartDto.price());
        newPart.setAvailable(true);
        newPart.setPartImage(addPartDto.partImage());
        newPart.getSubmodel().add(submodel);

        partRepository.save(newPart);
        return newPart;
    }

    @Override
    public List<Part> getAllPartsByGroupNameAndSubmodel(String group, List<Part> allPartsOfSubmodel) {
        List<Part> allPartsOfGivenGroup = new ArrayList<>();

        for (int i = 0; i < allPartsOfSubmodel.size(); i++) {
            Part currentPart = allPartsOfSubmodel.get(i);

            if (currentPart.getGroupName().equals(group)) {
                allPartsOfGivenGroup.add(currentPart);
            }
        }

        return allPartsOfGivenGroup;
    }

    @Override
    public Part addPartInShoppingCart(Long id) {
        Optional<Part> byId = partRepository.findById(id);

        return byId.orElse(null);

    }

    @Override
    public AllPartDtos showInShoppingCart(Part part) {
        List<PartDto> allPartsToShow = new ArrayList<>();

        PartDto partDto = new PartDto();
        partDto.setPartName(part.getPartName());
        partDto.setPrice(part.getPrice());
        allPartsToShow.add(partDto);

        return new AllPartDtos(allPartsToShow);
    }

}
