package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Usuario;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtém todos os usuários.
     *
     * @return uma lista de usuários.
     */
    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtém um usuário por ID.
     *
     * @param id o ID do usuário.
     * @return o usuário com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        return usuarioBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo usuário.
     *
     * @param usuario o novo usuário.
     * @return o usuário criado.
     */
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param id                          o ID do usuário a ser atualizado.
     * @param usuarioComDadosAtualizados os novos dados do usuário.
     * @return o usuário atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,
                                                 @RequestBody Usuario usuarioComDadosAtualizados) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuarioComDadosAtualizados.setIdUsuario(id);
            return ResponseEntity.ok(usuarioRepository.save(usuarioComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um usuário por ID.
     *
     * @param id o ID do usuário a ser excluído.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioParaDeletar = usuarioRepository.findById(id);
        if (usuarioParaDeletar.isPresent()) {
            usuarioRepository.delete(usuarioParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
