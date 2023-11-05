package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Submodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmodelRepository extends JpaRepository<Submodel, Long> {
}
