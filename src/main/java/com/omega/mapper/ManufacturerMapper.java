package com.omega.mapper;

import com.omega.model.dto.ManufacturerDTO;
import com.omega.model.dto.ProductDTO;
import com.omega.model.entity.Manufacturer;
import com.omega.model.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class ManufacturerMapper {

    public abstract Manufacturer dtoToEntity(ManufacturerDTO manufacturerDTO);

    @Mapping(target = "products", qualifiedByName = "pureProducts")
    public abstract ManufacturerDTO entityToDto(Manufacturer manufacturer);

    @Named("pureProducts")
    @Mappings({
            @Mapping(target = "categories", ignore = true),
            @Mapping(target = "manufacturer", ignore = true),
            @Mapping(target = "inventories", ignore = true)
    })
    abstract ProductDTO pureProducts(Product product);
}
