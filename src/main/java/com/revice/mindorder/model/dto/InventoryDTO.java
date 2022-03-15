package com.revice.mindorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {

    private Long id;

    private String name;

    private String address;

    private Long provinceId;

    private Long districtId;

    private Long wardId;

    private Collection<ProductDTO> products;

    public interface Groups {
        interface Create {
        }

        interface Update {
        }
    }

    public interface Views {
        interface Public {
        }

        interface Internal extends ProductDTO.Views.Public {
        }
    }
}
