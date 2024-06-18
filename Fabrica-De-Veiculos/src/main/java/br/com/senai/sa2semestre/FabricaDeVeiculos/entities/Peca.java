package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa uma peça no sistema.
 */
@Entity
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeca;
    private String pecas;
    private String descricao;

    @OneToMany(mappedBy = "peca", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Estoque> estoqueList = new ArrayList<>();

    @ManyToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Veiculo> veiculos = new ArrayList<>();

    @OneToMany(mappedBy = "peca", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producao> producoes = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Peca() {
    }

    /**
     * Construtor com todos os campos.
     * @param idPeca o ID da peça.
     * @param pecas o nome da peça.
     * @param descricao a descrição da peça.
     * @param estoqueList a lista de itens de estoque associados à peça.
     * @param veiculos a lista de veículos que utilizam a peça.
     * @param producoes a lista de produções que utilizam a peça.
     */
    public Peca(Long idPeca, String pecas, String descricao, List<Estoque> estoqueList, List<Veiculo> veiculos, List<Producao> producoes) {
        this.idPeca = idPeca;
        this.pecas = pecas;
        this.descricao = descricao;
        this.estoqueList = estoqueList;
        this.veiculos = veiculos;
        this.producoes = producoes;
    }

    /**
     * Obtém o ID da peça.
     * @return o ID da peça.
     */
    public Long getIdPeca() {
        return idPeca;
    }

    /**
     * Define o ID da peça.
     * @param idPeca o novo ID da peça.
     */
    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    /**
     * Obtém o nome da peça.
     * @return o nome da peça.
     */
    public String getPecas() {
        return pecas;
    }

    /**
     * Define o nome da peça.
     * @param pecas o novo nome da peça.
     */
    public void setPecas(String pecas) {
        this.pecas = pecas;
    }

    /**
     * Obtém a descrição da peça.
     * @return a descrição da peça.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da peça.
     * @param descricao a nova descrição da peça.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a lista de itens de estoque associados à peça.
     * @return a lista de itens de estoque associados à peça.
     */
    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    /**
     * Define a lista de itens de estoque associados à peça.
     * @param estoqueList a nova lista de itens de estoque associados à peça.
     */
    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    /**
     * Obtém a lista de veículos que utilizam a peça.
     * @return a lista de veículos que utilizam a peça.
     */
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * Define a lista de veículos que utilizam a peça.
     * @param veiculos a nova lista de veículos que utilizam a peça.
     */
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    /**
     * Obtém a lista de produções que utilizam a peça.
     * @return a lista de produções que utilizam a peça.
     */
    public List<Producao> getProducoes() {
        return producoes;
    }

    /**
     * Define a lista de produções que utilizam a peça.
     * @param producoes a nova lista de produções que utilizam a peça.
     */
    public void setProducoes(List<Producao> producoes) {
        this.producoes = producoes;
    }

    /**
     * Retorna uma representação em string da peça.
     * A string inclui o ID da peça, o nome, a descrição, a lista de estoque, veículos e produções.
     *
     * @return uma string que representa a peça.
     */
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
