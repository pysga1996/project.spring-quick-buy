package com.revice.mindorder.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Product.full",
                attributeNodes = {@NamedAttributeNode(value = "categories"),
                        @NamedAttributeNode(value = "manufacturer"),
                        @NamedAttributeNode(value = "inventories")}
        ),
        @NamedEntityGraph(name = "Product.manufacturer",
                attributeNodes = {@NamedAttributeNode(value = "manufacturer")}
        )
})
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_gen")
    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

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
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
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
