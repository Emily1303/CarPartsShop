package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Brand;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @EntityGraph(
            value = "brandWithModels",
            attributePaths = "models"
    )
    @Query("SELECT b FROM Brand b")
    List<Brand> getAllBrands();

    Optional<Brand> findByBrandName(String name);

}
