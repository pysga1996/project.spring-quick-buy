package com.revice.mindorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private Long id;

    private ProductDTO product;

    private Integer quantity;

    private CartDTO cart;

    private OrderDTO order;

    public interface Groups {
        interface Create {
        }

        interface Update {
        }
    }

    public interface Views {

        interface Public {
        }

        interface Internal extends ProductDTO.Views.Public, CartDTO.Views.Public, OrderDTO.Views.Public {
        }
    }
}
