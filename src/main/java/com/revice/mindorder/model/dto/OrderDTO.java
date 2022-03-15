package com.revice.mindorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    private Collection<ItemDTO> items;

    private Long userId;

    public interface Groups {
        interface Create {
        }

        interface Update {
        }
    }

    public interface Views {
        interface Public {
        }

        interface Internal extends ItemDTO.Views.Public {
        }
    }
}
