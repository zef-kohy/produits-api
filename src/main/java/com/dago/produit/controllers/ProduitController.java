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

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable long id){
        return produitService.getProduitById(id);
    }

    @PostMapping("/create")
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }

    @DeleteMapping("/{id}")
    public String deleteProduit(@PathVariable long id){
        produitService.deleteProduitById(id);

        return "Produit supprimé avec succès";
    }

    @PutMapping("/{id}")
    public Produit editProduit(@PathVariable long id, @RequestBody Produit produit){
        return produitService.editProduit(id, produit);
    }
}
