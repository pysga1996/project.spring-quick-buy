package com.omega.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    private String id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "category_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Collection<Category> categories;

    @Column
    private Float price;

    @Column
    private String description;

    @ManyToOne(targetEntity = Manufacturer.class)
    private Manufacturer manufacturer;

    @ManyToMany
    @JoinTable(name = "stock",
            joinColumns = {@JoinColumn(name = "inventory_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Collection<Inventory> inventories;
}
