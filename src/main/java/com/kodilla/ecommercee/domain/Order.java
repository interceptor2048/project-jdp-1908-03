package com.kodilla.ecommercee.domain;

<<<<<<< HEAD
import lombok.*;
=======
import lombok.AllArgsConstructor;
>>>>>>> b10fef649581f82a855b411eaf00d0d987ff230f

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */
@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @ManyToMany(mappedBy = "orders")
    private List<Product> products = new ArrayList<>();

    //TODO Add reference to User when it is created...
/*    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/
}