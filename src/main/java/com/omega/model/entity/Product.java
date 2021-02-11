package com.omega.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
@Table(name = "product", schema = "omega_buy")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_gen")
    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "category_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Category> categories;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Manufacturer manufacturer;

    @ManyToMany
    @JoinTable(name = "stock",
            joinColumns = {@JoinColumn(name = "inventory_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Inventory> inventories;
}
