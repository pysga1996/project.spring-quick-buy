package com.omega.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "item")
public class Item {

  @Id
  private String id;

  @ManyToOne(targetEntity = Product.class)
  @JoinColumn(name="product_id", referencedColumnName = "id")
  private Product product;

  @Column
  private Integer quantity;

  @ManyToOne(targetEntity = Cart.class)
  @JoinColumn(name = "cart_id", referencedColumnName = "id")
  private Cart cart;

  @ManyToOne(targetEntity = Order.class)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Order order;
}
