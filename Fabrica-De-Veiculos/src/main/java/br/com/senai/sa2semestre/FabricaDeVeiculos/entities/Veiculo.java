package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chassi;
    private String modelo;
    private Long ano;

    private String cor;

}
