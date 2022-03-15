package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.ItemDTO;
import com.revice.mindorder.model.entity.Item;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CartMapper.class, OrderMapper.class})
public abstract class ItemMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "product", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "cart", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "order", qualifiedBy = {PureMapping.class})
    })
    public abstract ItemDTO entityToDto(Item item);

    @FullMapping
    @Mappings({
            @Mapping(target = "product", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "cart", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "order", qualifiedBy = {PureMapping.class})
    })
    public abstract Item dtoToEntity(ItemDTO item);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<ItemDTO> entityToDtoList(List<Item> items);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Item> dtoToEntityList(List<ItemDTO> items);

    @PureMapping
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "cart", ignore = true),
            @Mapping(target = "order", ignore = true)
    })
    public abstract ItemDTO entityToDtoPure(Item item);

    @PureMapping
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "cart", ignore = true),
            @Mapping(target = "order", ignore = true)
    })
    public abstract Item dtoToEntityPure(ItemDTO item);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<ItemDTO> entityToDtoListPure(List<Item> items);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Item> dtoToEntityListPure(List<ItemDTO> items);
}
