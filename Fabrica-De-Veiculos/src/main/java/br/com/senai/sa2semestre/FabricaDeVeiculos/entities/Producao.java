package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    private String dataHora;
    private Long idPeca;
    private Long quantidadeProduzida;

    private String estado;


    public Producao() {
    }

    public Producao(Long idProducao, String dataHora, Long idPeca, Long quantidadeProduzida, String estado) {
        this.idProducao = idProducao;
        this.dataHora = dataHora;
        this.idPeca = idPeca;
        this.quantidadeProduzida = quantidadeProduzida;
        this.estado = estado;
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

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public Long getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(Long quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producao{" +
                "idProducao=" + idProducao +
                ", dataHora='" + dataHora + '\'' +
                ", idPeca=" + idPeca +
                ", quantidadeProduzida=" + quantidadeProduzida +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producao producao = (Producao) o;

        if (!idProducao.equals(producao.idProducao)) return false;
        if (!Objects.equals(dataHora, producao.dataHora)) return false;
        if (!idPeca.equals(producao.idPeca)) return false;
        if (!Objects.equals(quantidadeProduzida, producao.quantidadeProduzida))
            return false;
        return Objects.equals(estado, producao.estado);
    }

    @Override
    public int hashCode() {
        int result = idProducao.hashCode();
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + idPeca.hashCode();
        result = 31 * result + (quantidadeProduzida != null ? quantidadeProduzida.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
