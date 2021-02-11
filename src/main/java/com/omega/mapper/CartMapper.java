package com.omega.mapper;

import com.omega.model.dto.CartDTO;
import com.omega.model.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CartMapper {

    abstract CartDTO entityToDto(Cart cart);

    abstract Cart dtoToEntity(CartDTO cartDTO);
}
