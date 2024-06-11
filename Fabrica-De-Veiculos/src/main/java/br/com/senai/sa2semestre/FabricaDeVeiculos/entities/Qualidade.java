package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Qualidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInspecao;
    private Long idProducao;
    private String dataHora;
    private String resultado;
    private  String comentarios;

    public Qualidade() {
    }

    public Qualidade(Long idInspecao, Long idProducao, String dataHora, String resultado, String comentarios) {
        this.idInspecao = idInspecao;
        this.idProducao = idProducao;
        this.dataHora = dataHora;
        this.resultado = resultado;
        this.comentarios = comentarios;
    }

    public Long getIdInspecao() {
        return idInspecao;
    }

    public void setIdInspecao(Long idInspecao) {
        this.idInspecao = idInspecao;
    }

    public Long getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
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

    @Override
    public String toString() {
        return "Qualidade{" +
                "idInspecao=" + idInspecao +
                ", idProducao=" + idProducao +
                ", dataHora='" + dataHora + '\'' +
                ", resultado='" + resultado + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qualidade qualidade = (Qualidade) o;

        if (!idInspecao.equals(qualidade.idInspecao)) return false;
        if (!Objects.equals(idProducao, qualidade.idProducao)) return false;
        if (!Objects.equals(dataHora, qualidade.dataHora)) return false;
        if (!Objects.equals(resultado, qualidade.resultado)) return false;
        return Objects.equals(comentarios, qualidade.comentarios);
    }

    @Override
    public int hashCode() {
        int result = idInspecao.hashCode();
        result = 31 * result + (idProducao != null ? idProducao.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentarios != null ? comentarios.hashCode() : 0);
        return result;
    }
}
