package com.revice.mindorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailCommentDTO extends BaseDTO {

    private String orderDetailId;

    private String parentId;

    private Integer rating;

    private String review;

    private Integer status;

    public interface Groups {
        interface Create {
        }

        interface Update {
        }
    }

    public interface Views {
        interface Public {
        }

        interface Internal extends Public {
        }
    }

}
