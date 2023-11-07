package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Submodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubmodelRepository extends JpaRepository<Submodel, Long> {

    Optional<Submodel> findBySubmodelName(String name);

}
