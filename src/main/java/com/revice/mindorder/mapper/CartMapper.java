package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.CartDTO;
import com.revice.mindorder.model.entity.Cart;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class})
public abstract class CartMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "items", qualifiedBy = {PureMapping.class})
    })
    public abstract CartDTO entityToDto(Cart cart);

    @FullMapping
    @Mappings({
            @Mapping(target = "items", qualifiedBy = {PureMapping.class})
    })
    public abstract Cart dtoToEntity(CartDTO cart);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<CartDTO> entityToDtoList(List<Cart> carts);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Cart> dtoToEntityList(List<CartDTO> carts);

    @PureMapping
    @Mappings({
            @Mapping(target = "items", ignore = true)
    })
    public abstract CartDTO entityToDtoPure(Cart cart);

    @PureMapping
    @Mappings({
            @Mapping(target = "items", ignore = true)
    })
    public abstract Cart dtoToEntityPure(CartDTO cart);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<CartDTO> entityToDtoListPure(List<Cart> carts);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Cart> dtoToEntityListPure(List<CartDTO> carts);
}
