package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;
import java.util.*;

/**
 * Representa um veículo no sistema.
 */
@Entity
public class Veiculo {
    @Id
    @Column(name = "chassi", unique = true)
    private String chassi;
    private String modelo;
    private Long ano;
    private String cor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Veiculo_Pecas",
            joinColumns = @JoinColumn(name = "chassi", referencedColumnName = "chassi"),
            inverseJoinColumns = @JoinColumn(name = "id_peca", referencedColumnName = "idPeca"))
    private List<Peca> pecas = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Veiculo() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param chassi o chassi do veículo.
     * @param modelo o modelo do veículo.
     * @param ano o ano do veículo.
     * @param cor a cor do veículo.
     * @param pecas a lista de peças associadas ao veículo.
     */
    public Veiculo(String chassi, String modelo, Long ano, String cor, List<Peca> pecas) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.pecas = pecas;
    }

    /**
     * Obtém o chassi do veículo.
     *
     * @return o chassi do veículo.
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * Define o chassi do veículo.
     *
     * @param chassi o novo chassi do veículo.
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * Obtém o modelo do veículo.
     *
     * @return o modelo do veículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     *
     * @param modelo o novo modelo do veículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém o ano do veículo.
     *
     * @return o ano do veículo.
     */
    public Long getAno() {
        return ano;
    }

    /**
     * Define o ano do veículo.
     *
     * @param ano o novo ano do veículo.
     */
    public void setAno(Long ano) {
        this.ano = ano;
    }

    /**
     * Obtém a cor do veículo.
     *
     * @return a cor do veículo.
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor do veículo.
     *
     * @param cor a nova cor do veículo.
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Obtém a lista de peças associadas ao veículo.
     *
     * @return a lista de peças do veículo.
     */
    public List<Peca> getPecas() {
        return pecas;
    }

    /**
     * Define a lista de peças associadas ao veículo.
     *
     * @param pecas a nova lista de peças do veículo.
     */
    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    /**
     * Retorna uma representação em string do veículo.
     * A string inclui o chassi, modelo, ano, cor e a lista de peças.
     *
     * @return uma string que representa o veículo.
     */
    @Override
    public String toString() {
        return "Veiculo{" +
                "chassi='" + chassi + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", pecas=" + pecas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;
        return chassi.equals(veiculo.chassi) &&
                Objects.equals(modelo, veiculo.modelo) &&
                Objects.equals(ano, veiculo.ano) &&
                Objects.equals(cor, veiculo.cor) &&
                Objects.equals(pecas, veiculo.pecas);
    }

    @Override
    public int hashCode() {
        int result = chassi.hashCode();
        result = 31 * result + Objects.hashCode(modelo);
        result = 31 * result + Objects.hashCode(ano);
        result = 31 * result + Objects.hashCode(cor);
        result = 31 * result + Objects.hashCode(pecas);
        return result;
    }
}
