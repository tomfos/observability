package com.grafana.bservability.repository;


import com.grafana.bservability.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long> {
}