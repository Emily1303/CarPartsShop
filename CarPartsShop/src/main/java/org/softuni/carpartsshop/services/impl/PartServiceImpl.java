package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.repositories.PartRepository;
import org.softuni.carpartsshop.services.PartService;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }


}
