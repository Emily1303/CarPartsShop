package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Model;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    @EntityGraph(
            value = "modelsWithSubmodels",
            attributePaths = "submodels"
    )
    @Query("SELECT m FROM Model m")
    List<Model> getAllModels();

}
