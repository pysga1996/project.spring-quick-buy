package com.revice.mindorder.service;

import com.revice.mindorder.model.dto.OrderDetailCommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderDetailCommentService {

    Page<OrderDetailCommentDTO> getCommentPage(Pageable pageable);

    Optional<OrderDetailCommentDTO> getCommentById(String id);

    void saveManufacturer(OrderDetailCommentDTO orderDetailCommentDTO);

    void deleteManufacturer(String id);
}
