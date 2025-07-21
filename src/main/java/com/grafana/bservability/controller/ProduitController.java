package com.grafana.bservability.controller;

import com.grafana.bservability.model.Produit;
import com.grafana.bservability.service.ProduitService;
import io.micrometer.observation.annotation.Observed;
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
    @Observed(name = "produit.hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/tousLesProduits")
    @Observed(name = "produit.api.getAll")
    public List<Produit> getAllProduit() {
        return produitService.getAllProduit();
    }

    @PostMapping("/créerProduit")
    @Observed(name = "produit.api.create")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @DeleteMapping("/supprimer/{id}")
    @Observed(name = "produit.api.delete")
    public String deleteProduitById(@PathVariable long id) {
        return produitService.deleteProduitById(id);
    }

    @PutMapping("{id}")
    @Observed(name = "produit.api.update")
    public Produit modifierProduit(@PathVariable long id, @RequestBody Produit produit) {
        return produitService.modificationDuProdiut(id, produit);
    }

}
