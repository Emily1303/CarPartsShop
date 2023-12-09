package org.softuni.carpartsshop.repositories;

import org.softuni.carpartsshop.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

}
