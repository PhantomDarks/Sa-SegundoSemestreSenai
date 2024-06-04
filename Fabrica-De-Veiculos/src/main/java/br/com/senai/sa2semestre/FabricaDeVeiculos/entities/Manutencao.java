package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.Objects;

@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManutencao;
    @ManyToOne()
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    private Equipamento equipamento;
    private LocalDateTime dataTimeInicio;
    private LocalDateTime  dataTimeFim;
    private String descricaoServico;
    private String estado;

    public Manutencao() {
    }

    public Manutencao(Long idManutencao, Equipamento idEquipamento, LocalDateTime dataTimeInicio, LocalDateTime dataTimeFim, String descricaoServico, String estado) {
        this.idManutencao = idManutencao;
        this.equipamento = idEquipamento;
        this.dataTimeInicio = dataTimeInicio;
        this.dataTimeFim = dataTimeFim;
        this.descricaoServico = descricaoServico;
        this.estado = estado;
    }

    public Long getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    public Equipamento getIdEquipamento() {
        return equipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.equipamento = idEquipamento;
    }

    public LocalDateTime getDataTimeInicio() {
        return dataTimeInicio;
    }

    public void setDataTimeInicio(LocalDateTime dataTimeInicio) {
        this.dataTimeInicio = dataTimeInicio;
    }

    public LocalDateTime getDataTimeFim() {
        return dataTimeFim;
    }

    public void setDataTimeFim(LocalDateTime dataTimeFim) {
        this.dataTimeFim = dataTimeFim;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "idManutencao=" + idManutencao +
                ", idEquipamento=" + equipamento +
                ", dataTimeInicio=" + dataTimeInicio +
                ", dataTimeFim=" + dataTimeFim +
                ", descricaoServico='" + descricaoServico + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manutencao that = (Manutencao) o;

        if (!idManutencao.equals(that.idManutencao)) return false;
        if (!Objects.equals(equipamento, that.equipamento))
            return false;
        if (!Objects.equals(dataTimeInicio, that.dataTimeInicio))
            return false;
        if (!Objects.equals(dataTimeFim, that.dataTimeFim)) return false;
        if (!Objects.equals(descricaoServico, that.descricaoServico))
            return false;
        return Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        int result = idManutencao.hashCode();
        result = 31 * result + (equipamento != null ? equipamento.hashCode() : 0);
        result = 31 * result + (dataTimeInicio != null ? dataTimeInicio.hashCode() : 0);
        result = 31 * result + (dataTimeFim != null ? dataTimeFim.hashCode() : 0);
        result = 31 * result + (descricaoServico != null ? descricaoServico.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
