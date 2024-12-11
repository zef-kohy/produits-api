package com.dago.produit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long produit_id;

    private String name;

    private double price;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categoryList;
}
