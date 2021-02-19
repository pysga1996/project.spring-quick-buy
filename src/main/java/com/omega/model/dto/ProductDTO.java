package com.omega.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String code;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Internal.class)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<CategoryDTO> categories;

    @JsonView(Views.Public.class)
    private Float price;

    @JsonView(Views.Public.class)
    private String description;

    @JsonView(Views.Internal.class)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ManufacturerDTO manufacturer;

    @JsonView(Views.Internal.class)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<InventoryDTO> inventories;

    public interface Groups {
        interface Create {
        }

        interface Update {
        }
    }

    public interface Views {

        interface Public {
        }

        interface Internal extends Public, CategoryDTO.Views.Public,
                ManufacturerDTO.Views.Public, InventoryDTO.Views.Public {
        }
    }

}
