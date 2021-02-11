package com.omega.model.dto;

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
}
