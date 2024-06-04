package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
