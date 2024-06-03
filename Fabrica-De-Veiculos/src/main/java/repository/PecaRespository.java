package repository;

import model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaRespository extends JpaRepository<Peca, Long> {
}
