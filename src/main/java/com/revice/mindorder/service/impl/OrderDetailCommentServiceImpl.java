package com.revice.mindorder.service.impl;

import com.revice.mindorder.error.BusinessException;
import com.revice.mindorder.mapper.OrderDetailCommentMapper;
import com.revice.mindorder.model.dto.OrderDetailCommentDTO;
import com.revice.mindorder.model.entity.OrderDetailComment;
import com.revice.mindorder.repositories.OrderDetailCommentRepository;
import com.revice.mindorder.service.OrderDetailCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderDetailCommentServiceImpl implements OrderDetailCommentService {

    private final OrderDetailCommentRepository orderDetailCommentRepository;

    private final OrderDetailCommentMapper orderDetailCommentMapper;

    @Autowired
    public OrderDetailCommentServiceImpl(OrderDetailCommentRepository orderDetailCommentRepository,
                                         OrderDetailCommentMapper orderDetailCommentMapper) {
        this.orderDetailCommentRepository = orderDetailCommentRepository;
        this.orderDetailCommentMapper = orderDetailCommentMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrderDetailCommentDTO> getCommentPage(Pageable pageable) {
        return this.orderDetailCommentRepository.findCommentPage(pageable)
                .map(this.orderDetailCommentMapper::entityToDto);
    }

    @Override
    public Optional<OrderDetailCommentDTO> getCommentById(String id) {
        return Optional.ofNullable(this.orderDetailCommentMapper
                .entityToDto(this.orderDetailCommentRepository.findById(id).orElse(null)));
    }

    @Override
    @Transactional
    public void saveManufacturer(OrderDetailCommentDTO orderDetailCommentDTO) {
        OrderDetailComment comment;
        if (orderDetailCommentDTO.getId() == null) {
            comment = this.orderDetailCommentMapper.dtoToEntity(orderDetailCommentDTO);
        } else {
            Optional<OrderDetailComment> existedComment = this.orderDetailCommentRepository.findById(orderDetailCommentDTO.getId());
            if (!existedComment.isPresent()) {
                throw new BusinessException(409, "validation.manufacturer.exist");
            }
            comment = existedComment.get();
        }
        this.orderDetailCommentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteManufacturer(String id) {
        this.orderDetailCommentRepository.deleteById(id);
    }
}
