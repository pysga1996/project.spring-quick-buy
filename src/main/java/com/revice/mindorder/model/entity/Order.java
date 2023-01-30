package com.revice.mindorder.model.entity;

import com.revice.mindorder.config.general.CustomAuditingEntityListener;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Order")
@Table(name = "order")
@EntityListeners(CustomAuditingEntityListener.class)
public class Order extends BaseEntity {

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "shop_id", nullable = false)
  private String shopId;

  @Column(name = "shop_name")
  private String shopName;

  @CreatedBy
  @LastModifiedBy
  @Column(name = "customer_id", nullable = false)
  private String customerId;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "inventory_id")
  private String inventoryId;

  @Column(name = "delivery_id")
  private String deliveryId;

  @Column(name = "delivery_partner")
  private String deliveryPartner;

  @Column(name = "delivery_fee")
  private BigDecimal fee;

  @Column(name = "delivery_status")
  private String deliveryStatus;

  @Column(name = "payment_id")
  private String paymentId;

  @Column(name = "payment_method")
  private String paymentMethod;

  @Column(name = "payment_amount")
  private BigDecimal amount;

  @Column(name = "payment_discount")
  private BigDecimal discount;

  @Column(name = "payment_final_amount")
  private BigDecimal finalAmount;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Order order = (Order) o;
    return id != null && Objects.equals(id, order.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
