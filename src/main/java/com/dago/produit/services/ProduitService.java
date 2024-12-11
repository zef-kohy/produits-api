package com.dago.produit.services;

import com.dago.produit.exceptions.ProduitNotFoundException;
import com.dago.produit.model.Produit;
import com.dago.produit.repository.ProduitRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Produit getProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);
        if (optionalProduit.isPresent()){
            return optionalProduit.get();
        }
        throw new ProduitNotFoundException("Désolé le produit n'a pas été trouvé");
    }

    public String deleteProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);
        if (optionalProduit.isEmpty()){
            throw new ProduitNotFoundException("désolé le produit n'a pas été trouvé");
        }
        produitRepo.delete(optionalProduit.get());

        return "Produit supprimé avec succès";
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);
        if (optionalProduit.isEmpty()){
            throw new ProduitNotFoundException("Désolé produit non trouvé");
        }
        Produit produitAModifier = optionalProduit.get();

        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());

       return produitRepo.save(produitAModifier);
    }
}
