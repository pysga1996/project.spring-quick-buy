package com.omega.repositories;

import com.omega.model.entity.Manufacturer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    @EntityGraph("Manufacturer.products")
    @NonNull
    List<Manufacturer> findAll();

    @EntityGraph("Manufacturer.products")
    @NonNull
    Optional<Manufacturer> findById(@NonNull Long id);
}
