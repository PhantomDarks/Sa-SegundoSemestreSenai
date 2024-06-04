package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    private String dataHora;
    private Long idPeca;
    private Long quantidadeProduzida;

    private String estado;
}
