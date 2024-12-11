package com.dago.produit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private List<Produit> produitList;
}
