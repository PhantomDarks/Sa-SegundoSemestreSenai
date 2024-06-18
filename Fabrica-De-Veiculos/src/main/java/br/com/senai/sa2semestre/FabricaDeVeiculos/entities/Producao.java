package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Representa uma produção no sistema.
 */
@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    private String dataHora;
    private Long quantidadeProduzida;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca pecas;

    @OneToMany(mappedBy = "producao", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Qualidade> qualidadesList;

    /**
     * Construtor padrão.
     */
    public Producao() {
    }

    /**
     * Construtor com todos os campos.
     * @param idProducao o ID da produção.
     * @param dataHora a data e hora da produção.
     * @param quantidadeProduzida a quantidade produzida.
     * @param estado o estado da produção.
     * @param pecas a peça associada à produção.
     * @param qualidadesList a lista de qualidades associadas à produção.
     */
    public Producao(Long idProducao, String dataHora, Long quantidadeProduzida, String estado, Peca pecas, List<Qualidade> qualidadesList) {
        this.idProducao = idProducao;
        this.dataHora = dataHora;
        this.quantidadeProduzida = quantidadeProduzida;
        this.estado = estado;
        this.pecas = pecas;
        this.qualidadesList = qualidadesList;
    }

    /**
     * Obtém o ID da produção.
     * @return o ID da produção.
     */
    public Long getIdProducao() {
        return idProducao;
    }

    /**
     * Define o ID da produção.
     * @param idProducao o novo ID da produção.
     */
    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
    }

    /**
     * Obtém a data e hora da produção.
     * @return a data e hora da produção.
     */
    public String getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da produção.
     * @param dataHora a nova data e hora da produção.
     */
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém a quantidade produzida.
     * @return a quantidade produzida.
     */
    public Long getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    /**
     * Define a quantidade produzida.
     * @param quantidadeProduzida a nova quantidade produzida.
     */
    public void setQuantidadeProduzida(Long quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    /**
     * Obtém o estado da produção.
     * @return o estado da produção.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado da produção.
     * @param estado o novo estado da produção.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém a peça associada à produção.
     * @return a peça associada à produção.
     */
    public Peca getPecas() {
        return pecas;
    }

    /**
     * Define a peça associada à produção.
     * @param pecas a nova peça associada à produção.
     */
    public void setPecas(Peca pecas) {
        this.pecas = pecas;
    }

    /**
     * Obtém a lista de qualidades associadas à produção.
     * @return a lista de qualidades associadas à produção.
     */
    public List<Qualidade> getQualidadesList() {
        return qualidadesList;
    }

    /**
     * Define a lista de qualidades associadas à produção.
     * @param qualidadesList a nova lista de qualidades associadas à produção.
     */
    public void setQualidadesList(List<Qualidade> qualidadesList) {
        this.qualidadesList = qualidadesList;
    }

    /**
     * Retorna uma representação em string da produção.
     * A string inclui o ID da produção, a data e hora, a quantidade produzida, o estado, a peça associada e a lista de qualidades.
     *
     * @return uma string que representa a produção.
     */
    @Override
    public String toString() {
        return "Producao{" +
                "idProducao=" + idProducao +
                ", dataHora='" + dataHora + '\'' +
                ", quantidadeProduzida=" + quantidadeProduzida +
                ", estado='" + estado + '\'' +
                ", pecas=" + pecas +
                ", qualidadesList=" + qualidadesList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producao producao = (Producao) o;
        return idProducao.equals(producao.idProducao) &&
                Objects.equals(dataHora, producao.dataHora) &&
                Objects.equals(quantidadeProduzida, producao.quantidadeProduzida) &&
                Objects.equals(estado, producao.estado) &&
                Objects.equals(pecas, producao.pecas) &&
                Objects.equals(qualidadesList, producao.qualidadesList);
    }

    @Override
    public int hashCode() {
        int result = idProducao.hashCode();
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (quantidadeProduzida != null ? quantidadeProduzida.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        result = 31 * result + (qualidadesList != null ? qualidadesList.hashCode() : 0);
        return result;
    }
}
