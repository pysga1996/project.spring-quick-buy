package com.omega.repositories.impl;

import com.omega.model.entity.Product;
import com.omega.repositories.ProductRepositoryCustom;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @NonNull
    public List<Product> findAllFetchManufacturer() {
        String hql = "SELECT p FROM Product p";
        EntityGraph<?> entityGraph = this.entityManager.getEntityGraph("Product.manufacturer");
        return this.entityManager.createQuery(hql, Product.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }
}
