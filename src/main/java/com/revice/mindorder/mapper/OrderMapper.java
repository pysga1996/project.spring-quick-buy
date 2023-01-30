package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.OrderDTO;
import com.revice.mindorder.model.entity.Order;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @FullMapping
    public abstract OrderDTO entityToDto(Order order);

    @FullMapping
    public abstract Order dtoToEntity(OrderDTO order);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<OrderDTO> entityToDtoList(List<Order> orders);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Order> dtoToEntityList(List<OrderDTO> orders);

    @PureMapping
    public abstract OrderDTO entityToDtoPure(Order order);

    @PureMapping
    public abstract Order dtoToEntityPure(OrderDTO order);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<OrderDTO> entityToDtoListPure(List<Order> orders);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Order> dtoToEntityListPure(List<OrderDTO> orders);
}
