package com.revice.mindorder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO extends BaseDTO {

    private String orderId;

    private String productId;

    private String productName;

    private String productThumbnail;

    private String productVariant;

    private BigDecimal productPrice;

    private BigDecimal productDiscount;

    private BigDecimal productFinalPrice;

    private String bundleId;

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
