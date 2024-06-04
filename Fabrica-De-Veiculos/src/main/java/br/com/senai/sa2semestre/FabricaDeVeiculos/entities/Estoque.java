package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.util.List;

public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;
    @ManyToOne
    @JoinColumn(name = "pecas_idPecas")
    private List<Peca> pecaList;
    private Long quantidadeDisponivel;
}
