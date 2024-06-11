package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Qualidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInspecao;
    private String dataHora;
    private String resultado;
    private  String comentarios;

    @ManyToOne()
    @JoinColumn(name = "idProducao", referencedColumnName = "idProducao")
    private Producao producao;

    public Qualidade() {
    }

    public Qualidade(Long idInspecao, Long idProducao, String dataHora, String resultado, String comentarios, Producao producoes) {
        this.idInspecao = idInspecao;
        this.dataHora = dataHora;
        this.resultado = resultado;
        this.comentarios = comentarios;
        this.producao = producoes;
    }

    public Long getIdInspecao() {
        return idInspecao;
    }

    public void setIdInspecao(Long idInspecao) {
        this.idInspecao = idInspecao;
    }


    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Producao getProducoes() {
        return producao;
    }

    public void setProducoes(Producao producao) {
        this.producao = producao;
    }

    @Override
    public String toString() {
        return "Qualidade{" +
                "idInspecao=" + idInspecao +
                ", dataHora='" + dataHora + '\'' +
                ", resultado='" + resultado + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", producoes=" + producao +
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
        return Objects.equals(producao, qualidade.producao);
    }

    @Override
    public int hashCode() {
        int result = idInspecao.hashCode();
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentarios != null ? comentarios.hashCode() : 0);
        result = 31 * result + (producao != null ? producao.hashCode() : 0);
        return result;
    }
}
