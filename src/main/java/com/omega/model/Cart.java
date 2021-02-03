package com.omega.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cart")
public class Cart {

  @Id
  private String id;

  @OneToMany(mappedBy = "cart")
  private Collection<Item> items;

  @Column
  private Long userId;
}
