package com.revice.mindorder.repositories.impl;

import com.revice.mindorder.model.entity.OrderDetailComment;
import com.revice.mindorder.repositories.OrderDetailCommentRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDetailCommentRepositoryImpl implements OrderDetailCommentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @NonNull
    public Page<OrderDetailComment> findCommentPage(Pageable pageable) {
//        String hql = "SELECT m FROM Manufacturer m";
////                this.entityManager.getEntityGraph("Product.manufacturer");
//        return this.entityManager.createQuery(hql, OrderDetailComment.class)
//                .getResultList()
//                ;
        return null;
    }
}
