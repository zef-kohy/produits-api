package com.dago.produit.controllers;

import com.dago.produit.model.Produit;
import com.dago.produit.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")

public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Salut les gars !";
    }
    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping("/create")
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }
}
