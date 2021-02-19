package com.omega.mapper;

import com.omega.mapper.annotation.FullMapping;
import com.omega.mapper.annotation.PureMapping;
import com.omega.model.dto.InventoryDTO;
import com.omega.model.entity.Inventory;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class InventoryMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "products", qualifiedBy = {PureMapping.class})
    })
    public abstract InventoryDTO entityToDto(Inventory inventory);

    @FullMapping
    @Mappings({
            @Mapping(target = "products", qualifiedBy = {PureMapping.class})
    })
    public abstract Inventory dtoToEntity(InventoryDTO inventory);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<InventoryDTO> entityToDtoList(List<Inventory> inventories);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Inventory> dtoToEntityList(List<InventoryDTO> inventories);

    @PureMapping
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    public abstract InventoryDTO entityToDtoPure(Inventory inventory);

    @PureMapping
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    public abstract Inventory dtoToEntityPure(InventoryDTO inventory);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<InventoryDTO> entityToDtoListPure(List<Inventory> inventories);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Inventory> dtoToEntityListPure(List<InventoryDTO> inventories);
}
