package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

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
    private List<Estoque> estoqueList;

    @ManyToMany(mappedBy = "pecas")
    private Set<Veiculo> listVeiculo = new HashSet<>();

    public Peca() {
    }

    public Peca(Long idPeca, String pecas, String descrição, List<Estoque> estoqueList) {
        this.idPeca = idPeca;
        this.pecas = pecas;
        this.descrição = descrição;
        this.estoqueList = estoqueList;
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

    @Override
    public String toString() {
        return "Peca{" +
                "idPeca=" + idPeca +
                ", pecas='" + pecas + '\'' +
                ", descrição='" + descrição + '\'' +
                ", estoqueList=" + estoqueList +
                '}';
    }


}
