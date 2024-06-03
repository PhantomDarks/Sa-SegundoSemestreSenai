package repository;

import model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaVeiculo extends JpaRepository<model.PecaVeiculo, Long> {
}
