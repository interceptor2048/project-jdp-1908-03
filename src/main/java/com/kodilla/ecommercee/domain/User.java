package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private String status;

    @Column(name = "userKey")
    private Long userKey;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "user",
            fetch = FetchType.LAZY)

    @JsonManagedReference
    private List<Order> users = new ArrayList<> ();
}
