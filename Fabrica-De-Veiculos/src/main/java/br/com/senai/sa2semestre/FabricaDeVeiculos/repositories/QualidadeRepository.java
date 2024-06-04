package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Qualidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualidadeRepository extends JpaRepository<Qualidade, Long> {
}
