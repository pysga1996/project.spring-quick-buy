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
@Entity(name = "manufacturer")
public class Manufacturer {

  @Id
  private Long id;

  @Column
  private String description;

  @Column
  private String name;

  @OneToMany(targetEntity = Product.class, mappedBy = "manufacturer")
  private Collection<Product> products;
}
