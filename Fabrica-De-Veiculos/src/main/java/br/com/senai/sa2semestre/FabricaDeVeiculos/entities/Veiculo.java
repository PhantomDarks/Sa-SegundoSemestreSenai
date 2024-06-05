package br.com.senai.sa2semestre.FabricaDeVeiculos.entities;

import jakarta.persistence.*;

@Entity
public class Veiculo {
    @Id
    @Column(name = "Chassi", unique = true)
    private String chassi;
    private String modelo;
    private Long ano;

    private String cor;

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
