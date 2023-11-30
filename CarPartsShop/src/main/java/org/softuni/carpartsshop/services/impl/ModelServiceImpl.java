package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.repositories.ModelRepository;
import org.softuni.carpartsshop.services.ModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model addModel(AddCarDto addCarDto, Brand brand) {
        Optional<Model> byModelName = modelRepository.findByModelName(addCarDto.modelName());

        if (byModelName.isPresent()) {
             return byModelName.get();
        }

        Model newModel = new Model();
        newModel.setModelName(addCarDto.modelName());
        newModel.setBrand(brand);
        newModel.setUuid(UUID.randomUUID());

        modelRepository.save(newModel);
        return newModel;
    }
}
