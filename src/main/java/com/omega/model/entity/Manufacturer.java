package com.omega.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "manufacturer")
@Table(name = "manufacturer", schema = "omega_buy")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Manufacturer.products",
                attributeNodes = {@NamedAttributeNode(value = "products", subgraph = "Product.pureProducts")},
                subgraphs = {
                        @NamedSubgraph(name = "Product.pureProducts", attributeNodes = {})
                }
        )
})
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_id_gen")
    @SequenceGenerator(name = "manufacturer_id_gen", schema = "omega_buy",
            sequenceName = "manufacturer_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    private Set<Product> products;

}
