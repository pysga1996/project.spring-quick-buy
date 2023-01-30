package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.OrderDetailDTO;
import com.revice.mindorder.model.entity.OrderDetail;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderDetailMapper {

    @FullMapping
    public abstract OrderDetailDTO entityToDto(OrderDetail orderDetail);

    @FullMapping
    public abstract OrderDetail dtoToEntity(OrderDetailDTO orderDetail);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<OrderDetailDTO> entityToDtoList(List<OrderDetail> orderDetails);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<OrderDetail> dtoToEntityList(List<OrderDetailDTO> orderDetails);

    @PureMapping
    public abstract OrderDetailDTO entityToDtoPure(OrderDetail orderDetail);

    @PureMapping
    public abstract OrderDetail dtoToEntityPure(OrderDetailDTO orderDetail);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<OrderDetailDTO> entityToDtoListPure(List<OrderDetail> orderDetails);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<OrderDetail> dtoToEntityListPure(List<OrderDetailDTO> orderDetails);
}
