package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;
import org.softuni.carpartsshop.repositories.RoleRepository;
import org.softuni.carpartsshop.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findUserRole(RoleNamesEnum name) {
        return roleRepository.findByRoleName(name).get();
    }

}
