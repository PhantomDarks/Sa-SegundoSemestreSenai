package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeca;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "estoque")
    @JoinColumn(name = "estoque_id")
    private Set<Peca> pecas = new HashSet<>();
}
