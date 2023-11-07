package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.SubmodelRepository;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SubmodelServiceImpl implements SubmodelService {

    private final SubmodelRepository submodelRepository;

    public SubmodelServiceImpl(SubmodelRepository submodelRepository) {
        this.submodelRepository = submodelRepository;
    }

    @Override
    public Submodel addSubmodel(AddPartDto addPartDto, Model model) {
        Optional<Submodel> bySubmodelName =
                submodelRepository.findBySubmodelName(addPartDto.submodelName());

        if (bySubmodelName.isPresent()) {
            return bySubmodelName.get();
        }

        Submodel newSubmodel = new Submodel();
        newSubmodel.setSubmodelName(addPartDto.submodelName());
        newSubmodel.setEngine(addPartDto.engine());
        newSubmodel.setEngineCode(addPartDto.engineCode());
        newSubmodel.setHorsePower(addPartDto.horsePower());
        newSubmodel.setYear(addPartDto.year());
        newSubmodel.setFuel(FuelsEnum.valueOf(addPartDto.fuel()));
        newSubmodel.setUuid(UUID.randomUUID());
        newSubmodel.setModel(model);

        submodelRepository.save(newSubmodel);
        return newSubmodel;
    }
}
