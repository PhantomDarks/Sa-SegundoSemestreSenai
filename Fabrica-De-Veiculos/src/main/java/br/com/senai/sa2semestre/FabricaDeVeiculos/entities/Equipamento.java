package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Representa um equipamento no sistema.
 */
@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;

    private String tipoEquipamento;
    private String descricao;
    private String estado;

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Manutencao> listaDeManutencoes;

    /**
     * Construtor padrão.
     */
    public Equipamento() {
    }

    /**
     * Construtor com todos os campos.
     * @param idEquipamento o ID do equipamento.
     * @param tipoEquipamento o tipo do equipamento.
     * @param descricao a descrição do equipamento.
     * @param estado o estado do equipamento.
     * @param listaDeManutencoes a lista de manutenções do equipamento.
     */
    public Equipamento(Long idEquipamento, String tipoEquipamento, String descricao, String estado, List<Manutencao> listaDeManutencoes) {
        this.idEquipamento = idEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.descricao = descricao;
        this.estado = estado;
        this.listaDeManutencoes = listaDeManutencoes;
    }

    /**
     * Obtém o ID do equipamento.
     * @return o ID do equipamento.
     */
    public Long getIdEquipamento() {
        return idEquipamento;
    }

    /**
     * Define o ID do equipamento.
     * @param idEquipamento o novo ID do equipamento.
     */
    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    /**
     * Obtém o tipo do equipamento.
     * @return o tipo do equipamento.
     */
    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    /**
     * Define o tipo do equipamento.
     * @param tipoEquipamento o novo tipo do equipamento.
     */
    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    /**
     * Obtém a descrição do equipamento.
     * @return a descrição do equipamento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do equipamento.
     * @param descricao a nova descrição do equipamento.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o estado do equipamento.
     * @return o estado do equipamento.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado do equipamento.
     * @param estado o novo estado do equipamento.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém a lista de manutenções do equipamento.
     * @return a lista de manutenções.
     */
    public List<Manutencao> getListaDeManutencoes() {
        return listaDeManutencoes;
    }

    /**
     * Define a lista de manutenções do equipamento.
     * @param listaDeManutencoes a nova lista de manutenções.
     */
    public void setListaDeManutencoes(List<Manutencao> listaDeManutencoes) {
        this.listaDeManutencoes = listaDeManutencoes;
    }

    /**
     * Verifica se dois objetos Equipamento são iguais.
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipamento that = (Equipamento) o;

        if (!idEquipamento.equals(that.idEquipamento)) return false;
        if (!Objects.equals(tipoEquipamento, that.tipoEquipamento))
            return false;
        if (!Objects.equals(descricao, that.descricao))
            return false;
        if (!Objects.equals(estado, that.estado))
            return false;
        return Objects.equals(listaDeManutencoes, that.listaDeManutencoes);
    }

    /**
     * Calcula o código hash do objeto Equipamento.
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        int result = idEquipamento.hashCode();
        result = 31 * result + (tipoEquipamento != null ? tipoEquipamento.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (listaDeManutencoes != null ? listaDeManutencoes.hashCode() : 0);
        return result;
    }

    /**
     * Retorna uma representação em string do objeto Equipamento.
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Equipamento{" +
                "idEquipamento=" + idEquipamento +
                ", tipoEquipamento='" + tipoEquipamento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                ", listaDeManutencoes=" + listaDeManutencoes +
                '}';
    }
}
