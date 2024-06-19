package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Representa uma inspeção de qualidade no sistema.
 */
@Entity
public class Qualidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInspecao;
    private String dataHora;
    private String resultado;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "idProducao", referencedColumnName = "idProducao")
    private Producao producao;

    /**
     * Construtor padrão.
     */
    public Qualidade() {
    }

    /**
     * Construtor com todos os campos.
     * @param idInspecao o ID da inspeção.
     * @param dataHora a data e hora da inspeção.
     * @param resultado o resultado da inspeção.
     * @param comentarios os comentários da inspeção.
     * @param producao a produção associada à inspeção.
     */
    public Qualidade(Long idInspecao, String dataHora, String resultado, String comentarios, Producao producao) {
        this.idInspecao = idInspecao;
        this.dataHora = dataHora;
        this.resultado = resultado;
        this.comentarios = comentarios;
        this.producao = producao;
    }

    /**
     * Obtém o ID da inspeção.
     * @return o ID da inspeção.
     */
    public Long getIdInspecao() {
        return idInspecao;
    }

    /**
     * Define o ID da inspeção.
     * @param idInspecao o novo ID da inspeção.
     */
    public void setIdInspecao(Long idInspecao) {
        this.idInspecao = idInspecao;
    }

    /**
     * Obtém a data e hora da inspeção.
     * @return a data e hora da inspeção.
     */
    public String getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da inspeção.
     * @param dataHora a nova data e hora da inspeção.
     */
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém o resultado da inspeção.
     * @return o resultado da inspeção.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define o resultado da inspeção.
     * @param resultado o novo resultado da inspeção.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtém os comentários da inspeção.
     * @return os comentários da inspeção.
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Define os comentários da inspeção.
     * @param comentarios os novos comentários da inspeção.
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Obtém a produção associada à inspeção.
     * @return a produção associada à inspeção.
     */
    public Producao getProducao() {
        return producao;
    }

    /**
     * Define a produção associada à inspeção.
     * @param producao a nova produção associada à inspeção.
     */
    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    /**
     * Retorna uma representação em string da inspeção de qualidade.
     * A string inclui o ID da inspeção, a data e hora, o resultado, os comentários e a produção associada.
     *
     * @return uma string que representa a inspeção de qualidade.
     */
    @Override
    public String toString() {
        return "Qualidade{" +
                "idInspecao=" + idInspecao +
                ", dataHora='" + dataHora + '\'' +
                ", resultado='" + resultado + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", producao=" + producao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qualidade qualidade = (Qualidade) o;

        if (!idInspecao.equals(qualidade.idInspecao)) return false;
        if (!Objects.equals(dataHora, qualidade.dataHora)) return false;
        if (!Objects.equals(resultado, qualidade.resultado)) return false;
        if (!Objects.equals(comentarios, qualidade.comentarios))
            return false;
        return producao.equals(qualidade.producao);
    }

    @Override
    public int hashCode() {
        int result = idInspecao.hashCode();
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentarios != null ? comentarios.hashCode() : 0);
        result = 31 * result + producao.hashCode();
        return result;
    }
}
