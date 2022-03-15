package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.ManufacturerDTO;
import com.revice.mindorder.model.entity.Manufacturer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class ManufacturerMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "products", qualifiedBy = {PureMapping.class})
    })
    public abstract ManufacturerDTO entityToDto(Manufacturer manufacturer);

    @FullMapping
    @Mappings({
            @Mapping(target = "products", qualifiedBy = {PureMapping.class})
    })
    public abstract Manufacturer dtoToEntity(ManufacturerDTO manufacturer);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<ManufacturerDTO> entityToDtoList(List<Manufacturer> manufacturers);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Manufacturer> dtoToEntityList(List<ManufacturerDTO> manufacturers);

    @PureMapping
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    public abstract ManufacturerDTO entityToDtoPure(Manufacturer manufacturer);

    @PureMapping
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    public abstract Manufacturer dtoToEntityPure(ManufacturerDTO manufacturer);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<ManufacturerDTO> entityToDtoListPure(List<Manufacturer> manufacturers);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Manufacturer> dtoToEntityListPure(List<ManufacturerDTO> manufacturers);
}
