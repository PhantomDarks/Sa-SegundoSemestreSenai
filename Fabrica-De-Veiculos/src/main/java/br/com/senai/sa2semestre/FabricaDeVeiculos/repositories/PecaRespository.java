package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaRespository extends JpaRepository<Peca, Long> {
}
