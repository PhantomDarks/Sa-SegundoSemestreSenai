package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
