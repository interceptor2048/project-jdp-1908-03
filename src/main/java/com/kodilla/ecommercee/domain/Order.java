package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(mappedBy = "orders")
    private List<Product> products = new ArrayList<>();

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade= CascadeType.ALL
    )
    @JoinColumn(name = "user_id")
    private User user;
}