package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.repositories.BrandRepository;
import org.softuni.carpartsshop.repositories.ModelRepository;
import org.softuni.carpartsshop.services.ModelService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model addModel(AddPartDto addPartDto, Brand brand) {
        Optional<Model> byModelName = modelRepository.findByModelName(addPartDto.modelName());

        if (byModelName.isPresent()) {
             return byModelName.get();
        }

        Model newModel = new Model();
        newModel.setModelName(addPartDto.modelName());
        newModel.setBrand(brand);
        newModel.setUuid(UUID.randomUUID());

        modelRepository.save(newModel);
        return newModel;
    }
}
