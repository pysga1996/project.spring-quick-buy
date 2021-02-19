package com.omega.mapper;

import com.omega.mapper.annotation.FullMapping;
import com.omega.mapper.annotation.PureMapping;
import com.omega.model.dto.OrderDTO;
import com.omega.model.entity.Order;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class})
public abstract class OrderMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "items", qualifiedBy = {PureMapping.class})
    })
    public abstract OrderDTO entityToDto(Order order);

    @FullMapping
    @Mappings({
            @Mapping(target = "items", qualifiedBy = {PureMapping.class})
    })
    public abstract Order dtoToEntity(OrderDTO order);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<OrderDTO> entityToDtoList(List<Order> orders);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Order> dtoToEntityList(List<OrderDTO> orders);

    @PureMapping
    @Mappings({
            @Mapping(target = "items", ignore = true)
    })
    public abstract OrderDTO entityToDtoPure(Order order);

    @PureMapping
    @Mappings({
            @Mapping(target = "items", ignore = true)
    })
    public abstract Order dtoToEntityPure(OrderDTO order);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<OrderDTO> entityToDtoListPure(List<Order> orders);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Order> dtoToEntityListPure(List<OrderDTO> orders);
}
