package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Producao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {
}
