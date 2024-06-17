package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeca;
    private String pecas;
    private String descricao;

    @OneToMany(mappedBy = "pecas", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Estoque> estoqueList = new ArrayList<>();

    @ManyToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Veiculo> veiculos = new ArrayList<>();

    @OneToMany(mappedBy = "pecas",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producao> producoes= new ArrayList<>();

    public Peca() {
    }

    public Peca(Long idPeca, String pecas, String descricao, List<Estoque> estoqueList, List<Veiculo> veiculos, List<Producao> producoes) {
        this.idPeca = idPeca;
        this.pecas = pecas;
        this.descricao = descricao;
        this.estoqueList = estoqueList;
        this.veiculos = veiculos;
        this.producoes = producoes;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public String getPecas() {
        return pecas;
    }

    public void setPecas(String pecas) {
        this.pecas = pecas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Producao> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Producao> producoes) {
        this.producoes = producoes;
    }

    @Override
    public String toString() {
        return "Peca{" +
                "idPeca=" + idPeca +
                ", pecas='" + pecas + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estoqueList=" + estoqueList +
                ", veiculos=" + veiculos +
                ", producoes=" + producoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peca peca = (Peca) o;
        return idPeca.equals(peca.idPeca) && Objects.equals(pecas, peca.pecas) && Objects.equals(descricao, peca.descricao) && Objects.equals(estoqueList, peca.estoqueList) && Objects.equals(veiculos, peca.veiculos) && Objects.equals(producoes, peca.producoes);
    }

    @Override
    public int hashCode() {
        int result = idPeca.hashCode();
        result = 31 * result + Objects.hashCode(pecas);
        result = 31 * result + Objects.hashCode(descricao);
        result = 31 * result + Objects.hashCode(estoqueList);
        result = 31 * result + Objects.hashCode(veiculos);
        result = 31 * result + Objects.hashCode(producoes);
        return result;
    }
}
