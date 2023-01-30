package com.revice.mindorder.repositories;

import com.revice.mindorder.model.entity.OrderDetailComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.List;

public interface OrderDetailCommentRepositoryCustom {

    @NonNull
    Page<OrderDetailComment> findCommentPage(Pageable pageable);
}
