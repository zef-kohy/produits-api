package com.dago.produit.services;

import com.dago.produit.model.Produit;
import com.dago.produit.repository.ProduitRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepo produitRepo;

    public ProduitService(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    public List<Produit> getAllProduits() {
        return produitRepo.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepo.save(produit);
    }
}
