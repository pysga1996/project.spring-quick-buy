package com.omega.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order")
public class Order {

  @Id
  private String id;

  @OneToMany(targetEntity = Item.class, mappedBy = "order")
  private Collection<Item> items;

  @Column
  private Long userId;
}
