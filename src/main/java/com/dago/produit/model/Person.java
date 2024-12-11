package com.dago.produit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "person")
    private Set<Address> addressList;
}
