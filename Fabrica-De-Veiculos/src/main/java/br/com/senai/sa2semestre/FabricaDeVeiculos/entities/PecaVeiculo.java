package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PecaVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculoPeca;
    private String chassi;
    private Long quantidade;


}
