package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleNamesEnum name);

}
