package com.revice.mindorder.repositories;

import com.revice.mindorder.model.entity.OrderDetailComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailCommentRepository extends JpaRepository<OrderDetailComment, String>, OrderDetailCommentRepositoryCustom {
}
