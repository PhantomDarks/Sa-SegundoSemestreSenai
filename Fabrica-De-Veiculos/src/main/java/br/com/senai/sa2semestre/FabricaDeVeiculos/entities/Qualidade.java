package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Qualidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInspecao;
    private Long idProducao;
    private String dataHora;
    private String resultado;
    private  String comentarios;
}
