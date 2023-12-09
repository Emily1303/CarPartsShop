package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;

public interface RoleService {

    Role findUserRole(RoleNamesEnum name);

}
