package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private List<Product> products = new ArrayList<>();
}
