package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.*;

@Entity
public class Veiculo {
    @Id
    @Column(name = "chassi", unique = true)
    private String chassi;
    private String modelo;
    private Long ano;
    private String cor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
                name = "Veiculo_Pecas",
            joinColumns = @JoinColumn(name = "chassi", referencedColumnName = "chassi"),
            inverseJoinColumns = @JoinColumn(name = "id_peca", referencedColumnName = "idPeca"))
    private List<Peca> pecas = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(String chassi, String modelo, Long ano, String cor, List<Peca> pecas) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.pecas = pecas;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "chassi='" + chassi + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", pecas=" + pecas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;
        return chassi.equals(veiculo.chassi) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(ano, veiculo.ano) && Objects.equals(cor, veiculo.cor) && Objects.equals(pecas, veiculo.pecas);
    }

    @Override
    public int hashCode() {
        int result = chassi.hashCode();
        result = 31 * result + Objects.hashCode(modelo);
        result = 31 * result + Objects.hashCode(ano);
        result = 31 * result + Objects.hashCode(cor);
        result = 31 * result + Objects.hashCode(pecas);
        return result;
    }
}

