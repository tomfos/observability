package com.grafana.bservability.service;

//import lombok.RequiredArgsConstructor;
import com.grafana.bservability.model.Produit;
import com.grafana.bservability.repository.ProduitRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepo produitRepo;

    public ProduitService(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    //return all products
    public List<Produit> getAllProduit() {
        return produitRepo.findAll();
    }

    //add one product
    public Produit createProduit(Produit produit) {
        return produitRepo.save(produit);
    }


    //delete one product
    public String deleteProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);

        if(optionalProduit.isEmpty()) {
            throw new RuntimeException("Suppression impossible: produit inexistant");
        }

        produitRepo.delete(optionalProduit.get());
        return "Produit Supprimé avec Succes";
    }


    public Produit modificationDuProdiut(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepo.findById(id);

        if(optionalProduit.isEmpty()) {
            throw new RuntimeException("Modification impossible: produit inexistant");
        }

        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());

        return produitRepo.save(produitAModifier);

    }
}
