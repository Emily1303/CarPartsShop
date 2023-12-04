package org.softuni.carpartsshop.services.impl;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.SubmodelDto;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.SubmodelRepository;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SubmodelServiceImpl implements SubmodelService {

    private final SubmodelRepository submodelRepository;

    private final ModelMapper modelMapper;

    public SubmodelServiceImpl(SubmodelRepository submodelRepository, ModelMapper modelMapper) {
        this.submodelRepository = submodelRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public Submodel getSubmodel(AddPartDto addPartDto) {
        return submodelRepository.findBySubmodelName(addPartDto.submodelName()).get();
    }

    @Override
    public HomeDto getSubmodelsForHomePage() {
        List<Submodel> allSubmodels = submodelRepository.getAllSubmodels();
        List<SubmodelDto> submodelDtoList = new ArrayList<>();

        for (int i = 0; i < allSubmodels.size(); i++) {
            SubmodelDto submodelDto = modelMapper.map(allSubmodels.get(i), SubmodelDto.class);
            submodelDtoList.add(submodelDto);
        }

        return new HomeDto(submodelDtoList);
    }

    @Override
    public Submodel getSubmodelAndPartsByName(String name) {
        return submodelRepository.findBySubmodelName(name).get();
    }

}
