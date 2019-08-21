package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dawid Nogacz on 21.08.2019
 */
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
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();
}
