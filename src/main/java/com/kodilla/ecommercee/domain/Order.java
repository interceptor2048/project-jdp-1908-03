package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */
@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "send_date")
    private LocalDate sendDate;

    @Column(name = "delivered_date")
    private LocalDate deliveredDate;

    @OneToMany(targetEntity = Product.class,
               mappedBy = "order",
               cascade = {CascadeType.PERSIST, CascadeType.MERGE},
               fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}