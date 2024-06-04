package br.com.senai.sa2semestre.FabricaDeVeiculos.repositories;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
