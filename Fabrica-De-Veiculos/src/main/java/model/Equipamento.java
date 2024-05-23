package model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;

    private String tipoEquipamento;
    private String descricaoEquipamento;
    private String estadoEquipamento;
    @OneToMany(mappedBy = "equipamento")
    private List<Manutencao> listaDeManutencao;


    public Equipamento(Long idEquipamento, String tipoEquipamento, String descricaoEquipamento, String estadoEquipamento, List<Manutencao> listaDeManutencao) {
        this.idEquipamento = idEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.descricaoEquipamento = descricaoEquipamento;
        this.estadoEquipamento = estadoEquipamento;
        this.listaDeManutencao = listaDeManutencao;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
    }

    public String getEstadoEquipamento() {
        return estadoEquipamento;
    }

    public void setEstadoEquipamento(String estadoEquipamento) {
        this.estadoEquipamento = estadoEquipamento;
    }

    public List<Manutencao> getListaDeManutencao() {
        return listaDeManutencao;
    }

    public void setListaDeManutencao(List<Manutencao> listaDeManutencao) {
        this.listaDeManutencao = listaDeManutencao;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "idEquipamento=" + idEquipamento +
                ", tipoEquipamento='" + tipoEquipamento + '\'' +
                ", descricaoEquipamento='" + descricaoEquipamento + '\'' +
                ", estadoEquipamento='" + estadoEquipamento + '\'' +
                ", listaDeManutencao=" + listaDeManutencao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipamento that = (Equipamento) o;

        if (!idEquipamento.equals(that.idEquipamento)) return false;
        if (!Objects.equals(tipoEquipamento, that.tipoEquipamento))
            return false;
        if (!Objects.equals(descricaoEquipamento, that.descricaoEquipamento))
            return false;
        if (!Objects.equals(estadoEquipamento, that.estadoEquipamento))
            return false;
        return Objects.equals(listaDeManutencao, that.listaDeManutencao);
    }

    @Override
    public int hashCode() {
        int result = idEquipamento.hashCode();
        result = 31 * result + (tipoEquipamento != null ? tipoEquipamento.hashCode() : 0);
        result = 31 * result + (descricaoEquipamento != null ? descricaoEquipamento.hashCode() : 0);
        result = 31 * result + (estadoEquipamento != null ? estadoEquipamento.hashCode() : 0);
        result = 31 * result + (listaDeManutencao != null ? listaDeManutencao.hashCode() : 0);
        return result;
    }
}
