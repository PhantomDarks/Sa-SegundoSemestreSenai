package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    private String dataHora;
    private Long quantidadeProduzida;

    private String estado;

    @ManyToOne()
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca pecas;

    @OneToMany(mappedBy = "producao",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Qualidade> qualidadesList;


    public Producao() {
    }

    public Producao(Long idProducao, String dataHora, Long idPeca, Long quantidadeProduzida, String estado, Peca pecas, List<Qualidade> qualidadesList) {
        this.idProducao = idProducao;
        this.dataHora = dataHora;
        this.quantidadeProduzida = quantidadeProduzida;
        this.estado = estado;
        this.pecas = pecas;
        this.qualidadesList = qualidadesList;
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

    public Peca getPecas() {
        return pecas;
    }

    public void setPecas(Peca pecas) {
        this.pecas = pecas;
    }

    public List<Qualidade> getQualidadesList() {
        return qualidadesList;
    }

    public void setQualidadesList(List<Qualidade> qualidadesList) {
        this.qualidadesList = qualidadesList;
    }

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

        if (!idProducao.equals(producao.idProducao)) return false;
        if (!Objects.equals(dataHora, producao.dataHora)) return false;
        if (!Objects.equals(quantidadeProduzida, producao.quantidadeProduzida))
            return false;
        if (!Objects.equals(estado, producao.estado)) return false;
        if (!Objects.equals(pecas, producao.pecas)) return false;
        return Objects.equals(qualidadesList, producao.qualidadesList);
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
