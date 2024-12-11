package com.dago.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "adresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    private String street;

    private String city;

    private String state;

    @ManyToOne
    @JoinColumn(name = "id")
    private Person person;
}
