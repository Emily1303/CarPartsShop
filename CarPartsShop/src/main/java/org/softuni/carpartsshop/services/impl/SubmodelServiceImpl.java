package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
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
    public Submodel addSubmodel(AddCarDto addCarDto, Model model) {
        Optional<Submodel> bySubmodelName =
                submodelRepository.findBySubmodelName(addCarDto.submodelName());

        if (bySubmodelName.isPresent()) {
            return bySubmodelName.get();
        }

        Submodel newSubmodel = new Submodel();
        newSubmodel.setSubmodelName(addCarDto.submodelName());
        newSubmodel.setEngine(addCarDto.engine());
        newSubmodel.setEngineCode(addCarDto.engineCode());
        newSubmodel.setHorsePower(addCarDto.horsePower());
        newSubmodel.setYear(addCarDto.year());
        newSubmodel.setFuel(FuelsEnum.valueOf(addCarDto.fuel()));
        newSubmodel.setSubmodelImage(addCarDto.submodelImage());
        newSubmodel.setUuid(UUID.randomUUID());
        newSubmodel.setModel(model);

        submodelRepository.save(newSubmodel);
        return newSubmodel;
    }
}
