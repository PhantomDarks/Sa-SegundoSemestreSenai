package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Estoque;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de estoques.
 */
@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    /**
     * Obtém todos os estoques.
     *
     * @return uma lista de estoques.
     */
    @GetMapping
    public List<Estoque> getAllEstoque() {
        return estoqueRepository.findAll();
    }

    /**
     * Obtém um estoque por ID.
     *
     * @param id o ID do estoque.
     * @return o estoque com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
        Optional<Estoque> estoqueBuscado = estoqueRepository.findById(id);
        return estoqueBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo estoque.
     *
     * @param estoque o novo estoque.
     * @return o estoque criado.
     */
    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    /**
     * Atualiza um estoque existente.
     *
     * @param id                          o ID do estoque a ser atualizado.
     * @param estoqueComDadosAtualizados os novos dados do estoque.
     * @return o estoque atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable Long id,
                                                 @RequestBody Estoque estoqueComDadosAtualizados) {
        Optional<Estoque> estoqueExistente = estoqueRepository.findById(id);
        if (estoqueExistente.isPresent()) {
            estoqueComDadosAtualizados.setIdEstoque(id);
            return ResponseEntity.ok(estoqueRepository.save(estoqueComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um estoque por ID.
     *
     * @param id o ID do estoque a ser excluído.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        Optional<Estoque> estoqueParaDeletar = estoqueRepository.findById(id);
        if (estoqueParaDeletar.isPresent()) {
            estoqueRepository.delete(estoqueParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
