package com.omega.mapper;

import com.omega.model.dto.CategoryDTO;
import com.omega.model.dto.InventoryDTO;
import com.omega.model.dto.ManufacturerDTO;
import com.omega.model.dto.ProductDTO;
import com.omega.model.entity.Category;
import com.omega.model.entity.Inventory;
import com.omega.model.entity.Manufacturer;
import com.omega.model.entity.Product;
import org.mapstruct.*;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    abstract Product dtoToEntity(ProductDTO productDTO);

    @Mappings({
            @Mapping(target = "categories", qualifiedByName = "pureCategories"),
            @Mapping(target = "manufacturer", qualifiedByName = "pureManufacturer"),
            @Mapping(target = "inventories", qualifiedByName = "pureInventories")
    })
    abstract ProductDTO entityToDto(Product product);

    @Named("pureCategories")
    @IterableMapping(qualifiedByName = "pureCategory")
    abstract Collection<CategoryDTO> pureCategories(Set<Category> categories);

    @Named("pureCategory")
    @Mapping(target = "products", ignore = true)
    abstract CategoryDTO pureCategory(Category category);

    @Named("pureManufacturer")
    @Mapping(target = "products", ignore = true)
    abstract ManufacturerDTO pureManufacturer(Manufacturer manufacturer);

    @Named("pureInventories")
    @IterableMapping(qualifiedByName = "pureInventory")
    abstract Collection<InventoryDTO> pureInventories(Set<Inventory> inventories);

    @Named("pureInventory")
    @Mapping(target = "products", ignore = true)
    abstract InventoryDTO pureInventory(Inventory inventory);
}
