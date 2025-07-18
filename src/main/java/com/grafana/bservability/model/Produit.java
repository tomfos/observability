package com.grafana.bservability.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue
    private Long produit_id;

    private String name;
    private double price;
}
