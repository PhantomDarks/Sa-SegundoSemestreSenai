package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
