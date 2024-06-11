package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeca;
    private String pecas;
    private String descrição;
    @OneToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Estoque> estoqueList;

    @ManyToMany(mappedBy = "pecas")
    private Set<Veiculo> listVeiculo = new HashSet<>();

    @OneToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Producao> producoes;

    public Peca() {
    }

    public Peca(Long idPeca, String pecas, String descrição, List<Estoque> estoqueList, Set<Veiculo> listVeiculo, List<Producao> producoes) {
        this.idPeca = idPeca;
        this.pecas = pecas;
        this.descrição = descrição;
        this.estoqueList = estoqueList;
        this.listVeiculo = listVeiculo;
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

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    public Set<Veiculo> getListVeiculo() {
        return listVeiculo;
    }

    public void setListVeiculo(Set<Veiculo> listVeiculo) {
        this.listVeiculo = listVeiculo;
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
                ", descrição='" + descrição + '\'' +
                ", estoqueList=" + estoqueList +
                ", listVeiculo=" + listVeiculo +
                ", producoes=" + producoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peca peca = (Peca) o;

        if (!idPeca.equals(peca.idPeca)) return false;
        if (!Objects.equals(pecas, peca.pecas)) return false;
        if (!Objects.equals(descrição, peca.descrição)) return false;
        if (!Objects.equals(estoqueList, peca.estoqueList)) return false;
        if (!Objects.equals(listVeiculo, peca.listVeiculo)) return false;
        return Objects.equals(producoes, peca.producoes);
    }

    @Override
    public int hashCode() {
        int result = idPeca.hashCode();
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        result = 31 * result + (descrição != null ? descrição.hashCode() : 0);
        result = 31 * result + (estoqueList != null ? estoqueList.hashCode() : 0);
        result = 31 * result + (listVeiculo != null ? listVeiculo.hashCode() : 0);
        result = 31 * result + (producoes != null ? producoes.hashCode() : 0);
        return result;
    }
}
