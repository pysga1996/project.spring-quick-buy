package com.revice.mindorder.mapper;

import com.revice.mindorder.mapper.annotation.FullMapping;
import com.revice.mindorder.mapper.annotation.PureMapping;
import com.revice.mindorder.model.dto.CategoryDTO;
import com.revice.mindorder.model.entity.Category;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class CategoryMapper {

    @FullMapping
    @Mappings({
            @Mapping(target = "products", qualifiedBy = {PureMapping.class})
    })
    public abstract CategoryDTO entityToDto(Category category);

    @FullMapping
    @Mappings({
            @Mapping(target = "products", qualifiedBy = {PureMapping.class})
    })
    public abstract Category dtoToEntity(CategoryDTO category);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<CategoryDTO> entityToDtoList(List<Category> categories);

    @FullMapping
    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<Category> dtoToEntityList(List<CategoryDTO> categories);

    @PureMapping
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    public abstract CategoryDTO entityToDtoPure(Category category);

    @PureMapping
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    public abstract Category dtoToEntityPure(CategoryDTO category);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<CategoryDTO> entityToDtoListPure(List<Category> categories);

    @PureMapping
    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Category> dtoToEntityListPure(List<CategoryDTO> categories);
}
