package com.revice.mindorder.repositories.impl;

import com.revice.mindorder.model.entity.Manufacturer;
import com.revice.mindorder.repositories.ManufacturerRepositoryCustom;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ManufacturerRepositoryImpl implements ManufacturerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @NonNull
    public List<Manufacturer> findAllNoFetch() {
        String hql = "SELECT m FROM Manufacturer m";
//                this.entityManager.getEntityGraph("Product.manufacturer");
        return this.entityManager.createQuery(hql, Manufacturer.class)
                .getResultList()
                ;
    }
}
