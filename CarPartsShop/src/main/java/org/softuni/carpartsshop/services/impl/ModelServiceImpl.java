package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.repositories.ModelRepository;
import org.softuni.carpartsshop.services.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

}
