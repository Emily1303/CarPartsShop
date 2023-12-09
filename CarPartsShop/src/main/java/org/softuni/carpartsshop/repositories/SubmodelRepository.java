package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Submodel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmodelRepository extends JpaRepository<Submodel, Long> {

    @EntityGraph(
            value = "submodelsWithParts",
            attributePaths = "parts"
    )
    @Query("SELECT s FROM Submodel s")
    List<Submodel> getAllSubmodels();

    Optional<Submodel> findBySubmodelName(String name);

}
