package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa uma manutenção no sistema.
 */
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManutencao;

    @ManyToOne()
    @JoinColumn(name = "idEquipamento")
    private Equipamento equipamento;

    private LocalDateTime dataTimeInicio;
    private LocalDateTime dataTimeFim;
    private String descricaoServico;
    private String estado;

    /**
     * Construtor padrão.
     */
    public Manutencao() {
    }

    /**
     * Construtor com todos os campos.
     * @param idManutencao o ID da manutenção.
     * @param idEquipamento o equipamento que está em manutenção.
     * @param dataTimeInicio a data e hora de início da manutenção.
     * @param dataTimeFim a data e hora de fim da manutenção.
     * @param descricaoServico a descrição do serviço realizado.
     * @param estado o estado da manutenção.
     */
    public Manutencao(Long idManutencao, Equipamento idEquipamento, LocalDateTime dataTimeInicio, LocalDateTime dataTimeFim, String descricaoServico, String estado) {
        this.idManutencao = idManutencao;
        this.equipamento = idEquipamento;
        this.dataTimeInicio = dataTimeInicio;
        this.dataTimeFim = dataTimeFim;
        this.descricaoServico = descricaoServico;
        this.estado = estado;
    }

    /**
     * Obtém o ID da manutenção.
     * @return o ID da manutenção.
     */
    public Long getIdManutencao() {
        return idManutencao;
    }

    /**
     * Define o ID da manutenção.
     * @param idManutencao o novo ID da manutenção.
     */
    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    /**
     * Obtém o equipamento que está em manutenção.
     * @return o equipamento que está em manutenção.
     */
    public Equipamento getIdEquipamento() {
        return equipamento;
    }

    /**
     * Define o equipamento que está em manutenção.
     * @param idEquipamento o novo equipamento que está em manutenção.
     */
    public void setIdEquipamento(Equipamento idEquipamento) {
        this.equipamento = idEquipamento;
    }

    /**
     * Obtém a data e hora de início da manutenção.
     * @return a data e hora de início da manutenção.
     */
    public LocalDateTime getDataTimeInicio() {
        return dataTimeInicio;
    }

    /**
     * Define a data e hora de início da manutenção.
     * @param dataTimeInicio a nova data e hora de início da manutenção.
     */
    public void setDataTimeInicio(LocalDateTime dataTimeInicio) {
        this.dataTimeInicio = dataTimeInicio;
    }

    /**
     * Obtém a data e hora de fim da manutenção.
     * @return a data e hora de fim da manutenção.
     */
    public LocalDateTime getDataTimeFim() {
        return dataTimeFim;
    }

    /**
     * Define a data e hora de fim da manutenção.
     * @param dataTimeFim a nova data e hora de fim da manutenção.
     */
    public void setDataTimeFim(LocalDateTime dataTimeFim) {
        this.dataTimeFim = dataTimeFim;
    }

    /**
     * Obtém a descrição do serviço realizado na manutenção.
     * @return a descrição do serviço realizado.
     */
    public String getDescricaoServico() {
        return descricaoServico;
    }

    /**
     * Define a descrição do serviço realizado na manutenção.
     * @param descricaoServico a nova descrição do serviço realizado.
     */
    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    /**
     * Obtém o estado da manutenção.
     * @return o estado da manutenção.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado da manutenção.
     * @param estado o novo estado da manutenção.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna uma representação em string da manutenção.
     * A string inclui o ID da manutenção, o equipamento, a data e hora de início e fim, a descrição do serviço e o estado.
     *
     * @return uma string que representa a manutenção.
     */
    @Override
    public String toString() {
        return "Manutencao{" +
                "idManutencao=" + idManutencao +
                ", equipamento=" + equipamento +
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
        return idManutencao.equals(that.idManutencao) && equipamento.equals(that.equipamento) && Objects.equals(dataTimeInicio, that.dataTimeInicio) && Objects.equals(dataTimeFim, that.dataTimeFim) && Objects.equals(descricaoServico, that.descricaoServico) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        int result = idManutencao.hashCode();
        result = 31 * result + equipamento.hashCode();
        result = 31 * result + Objects.hashCode(dataTimeInicio);
        result = 31 * result + Objects.hashCode(dataTimeFim);
        result = 31 * result + Objects.hashCode(descricaoServico);
        result = 31 * result + Objects.hashCode(estado);
        return result;
    }
}
