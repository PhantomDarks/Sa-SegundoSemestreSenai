package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;

    @ManyToOne()
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca pecas;
    private Long quantidadeDisponivel;

    public Estoque() {
    }

    public Estoque(Peca pecas, Long quantidadeDisponivel) {
        this.pecas = pecas;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Long getIdEstoque() {
        return idEstoque;
    }


    public Peca getPecas() {
        return pecas;
    }

    public void setPecas(Peca pecas) {
        this.pecas = pecas;
    }

    public Long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + idEstoque +
                ", pecas=" + pecas +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return idEstoque.equals(estoque.idEstoque) && Objects.equals(pecas, estoque.pecas) && Objects.equals(quantidadeDisponivel, estoque.quantidadeDisponivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstoque, pecas, quantidadeDisponivel);
    }
}
