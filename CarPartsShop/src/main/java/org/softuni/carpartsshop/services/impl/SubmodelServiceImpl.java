package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.repositories.SubmodelRepository;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Service;

@Service
public class SubmodelServiceImpl implements SubmodelService {

    private final SubmodelRepository submodelRepository;

    public SubmodelServiceImpl(SubmodelRepository submodelRepository) {
        this.submodelRepository = submodelRepository;
    }

}
