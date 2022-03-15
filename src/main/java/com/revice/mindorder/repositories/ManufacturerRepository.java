package com.revice.mindorder.repositories;

import com.revice.mindorder.model.entity.Manufacturer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>, ManufacturerRepositoryCustom {

    @NonNull
    List<Manufacturer> findAll();

    @EntityGraph(value = "Manufacturer.products", type = EntityGraph.EntityGraphType.FETCH)
    @NonNull
    Optional<Manufacturer> findById(@NonNull Long id);

    boolean existsByCode(String code);

    boolean existsByCodeAndIdNot(String code, Long id);
}
