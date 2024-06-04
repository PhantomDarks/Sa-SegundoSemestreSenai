package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pecas;
    private String descrição;
    @OneToMany(mappedBy = "pecas")
    private List<Estoque> estoqueList;
}
