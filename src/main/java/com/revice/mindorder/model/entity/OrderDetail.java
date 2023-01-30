package com.revice.mindorder.model.entity;

import com.revice.mindorder.config.general.CustomAuditingEntityListener;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OrderDetail")
@Table(name = "order_detail")
@EntityListeners(CustomAuditingEntityListener.class)
public class OrderDetail extends BaseEntity {

  @Column(name = "order_id", nullable = false)
  private String orderId;

  @Column(name = "product_id", nullable = false)
  private String productId;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "product_thumbnail")
  private String productThumbnail;

  @Column(name = "product_variant")
  private String productVariant;

  @Column(name = "product_price", nullable = false)
  private BigDecimal productPrice;

  @Column(name = "product_discount")
  private BigDecimal productDiscount;

  @Column(name = "product_final_price", nullable = false)
  private BigDecimal productFinalPrice;

  @Column(name = "bundle_id")
  private String bundleId;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    OrderDetail that = (OrderDetail) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
