package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Peca;
import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Veiculo;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.PecaRepository;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controlador REST para gerenciamento de Peça.
 */
@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaRepository pecaRepository;

    /**
     * Obtém todas as peças.
     *
     * @return uma lista de peças.
     */
    @GetMapping
    public List<Peca> getAllPeca() {
        return pecaRepository.findAll();
    }

    /**
     * Obtém uma peça por ID.
     *
     * @param id o ID da peça.
     * @return a peça com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Peca> getPecaById(@PathVariable Long id) {
        Optional<Peca> pecaBuscada = pecaRepository.findById(id);
        return pecaBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova peça.
     *
     * @param peca a nova peça.
     * @return a peça criada.
     */
    @PostMapping
    public Peca createPeca(@RequestBody Peca peca) {

        return pecaRepository.save(peca);
    }

    /**
     * Atualiza uma peça existente.
     *
     * @param id                    o ID da peça a ser atualizada.
     * @param pecaComDadosAtualizados os novos dados da peça.
     * @return a peça atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Peca> updatePeca(@PathVariable Long id,
                                           @RequestBody Peca pecaComDadosAtualizados) {
        Optional<Peca> pecaExistente = pecaRepository.findById(id);
        if (pecaExistente.isPresent()) {
            pecaComDadosAtualizados.setIdPeca(id);
            return ResponseEntity.ok(pecaRepository.save(pecaComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma peça por ID.
     *
     * @param id o ID da peça a ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Peca> pecaParaDeletar = pecaRepository.findById(id);
        if (pecaParaDeletar.isPresent()) {
            pecaRepository.delete(pecaParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
