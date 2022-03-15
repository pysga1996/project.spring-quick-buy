package com.revice.mindorder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cart")
@Table(name = "cart")
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(mappedBy = "cart", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Collection<Item> items;

  @Column
  private Long userId;
}
