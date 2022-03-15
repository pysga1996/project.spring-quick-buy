package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.ProductDTO;
import com.revice.mindorder.model.entity.Product;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ManufacturerMapper.class, InventoryMapper.class})
public abstract class ProductMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "categories", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "manufacturer", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "inventories", qualifiedBy = {PureMapping.class})
    })
    public abstract ProductDTO entityToDto(Product product);

    @FullMapping
    @Mappings({
            @Mapping(target = "categories", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "manufacturer", qualifiedBy = {PureMapping.class}),
            @Mapping(target = "inventories", qualifiedBy = {PureMapping.class})
    })
    public abstract Product dtoToEntity(ProductDTO product);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<ProductDTO> entityToDtoList(List<Product> products);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Product> dtoToEntityList(List<ProductDTO> products);

    @PureMapping
    @Mappings({
            @Mapping(target = "categories", ignore = true),
            @Mapping(target = "manufacturer", ignore = true),
            @Mapping(target = "inventories", ignore = true)
    })
    public abstract ProductDTO entityToDtoPure(Product product);

    @PureMapping
    @Mappings({
            @Mapping(target = "categories", ignore = true),
            @Mapping(target = "manufacturer", ignore = true),
            @Mapping(target = "inventories", ignore = true)
    })
    public abstract Product dtoToEntityPure(ProductDTO product);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<ProductDTO> entityToDtoListPure(List<Product> products);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Product> dtoToEntityListPure(List<ProductDTO> products);
}
