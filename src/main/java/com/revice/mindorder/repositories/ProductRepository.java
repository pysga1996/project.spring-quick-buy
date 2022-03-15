package com.revice.mindorder.repositories;

import com.revice.mindorder.model.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    @NonNull
    List<Product> findAll();

    @EntityGraph(value = "Product.full", type = EntityGraph.EntityGraphType.FETCH)
    @NonNull
    Optional<Product> findById(@NonNull Long id);

    boolean existsByCode(String code);

    boolean existsByCodeAndIdNot(String code, Long id);
}
