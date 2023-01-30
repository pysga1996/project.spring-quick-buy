package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.OrderDetailCommentDTO;
import com.revice.mindorder.model.entity.OrderDetailComment;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderDetailCommentMapper {

    @FullMapping
    public abstract OrderDetailCommentDTO entityToDto(OrderDetailComment orderDetailComment);

    @FullMapping
    public abstract OrderDetailComment dtoToEntity(OrderDetailCommentDTO orderDetailComment);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<OrderDetailCommentDTO> entityToDtoList(List<OrderDetailComment> orderDetailComments);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<OrderDetailComment> dtoToEntityList(List<OrderDetailCommentDTO> orderDetailComments);

    @PureMapping
    public abstract OrderDetailCommentDTO entityToDtoPure(OrderDetailComment orderDetailComment);

    @PureMapping
    public abstract OrderDetailComment dtoToEntityPure(OrderDetailCommentDTO orderDetailComment);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<OrderDetailCommentDTO> entityToDtoListPure(List<OrderDetailComment> orderDetailComments);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<OrderDetailComment> dtoToEntityListPure(List<OrderDetailCommentDTO> manufacturers);
}
