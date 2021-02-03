package com.omega.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "inventory")
public class Inventory {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Long provinceId;

    @Column
    private Long districtId;

    @Column
    private Long wardId;

    @ManyToMany(mappedBy = "inventories")
    private Collection<Product> products;
}
