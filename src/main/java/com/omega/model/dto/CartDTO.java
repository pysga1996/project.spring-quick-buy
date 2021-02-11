package com.omega.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long id;

    private Collection<ItemDTO> items;

    private Long userId;
}
