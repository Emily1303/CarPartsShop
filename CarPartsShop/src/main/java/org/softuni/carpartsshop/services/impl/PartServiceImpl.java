package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.repositories.PartRepository;
import org.softuni.carpartsshop.services.PartService;
import org.springframework.stereotype.Service;

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
        newPart.setUuid(UUID.randomUUID());
        newPart.setAvailable(true);
        newPart.getSubmodel().add(submodel);

        partRepository.save(newPart);
        return newPart;
    }
}
