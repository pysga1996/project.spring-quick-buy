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
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Manufacturer.products",
                attributeNodes = {@NamedAttributeNode(value = "products", subgraph = "Product.pureProducts")},
                subgraphs = {
                        @NamedSubgraph(name = "Product.pureProducts", attributeNodes = {})
                }
        )
})
@Entity(name = "Manufacturer")
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_id_gen")
    @SequenceGenerator(name = "manufacturer_id_gen", sequenceName = "manufacturer_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<Product> products;

}
