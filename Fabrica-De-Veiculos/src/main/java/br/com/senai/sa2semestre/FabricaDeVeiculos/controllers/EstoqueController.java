package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Estoque;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    /**
     * Controlador REST para gerenciamento de equipamentos.
     */
    @RestController
    @RequestMapping("/estoque")
    public class EstoqueController {

        @Autowired
        private EstoqueRepository estoqueRepository;

        /**
         * Obtém todos os equipamentos.
         *
         * @return uma lista de equipamentos.
         */
        @GetMapping
        public List<Estoque> getAllEquipamentos() {
            return estoqueRepository.findAll();
        }

        /**
         * Obtém um equipamento por ID.
         * @param id o ID do equipamento.
         * @return o equipamento com o ID especificado.
         */
        @GetMapping("/{id}")
        public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
            Optional<Estoque> equipamentoBuscado = estoqueRepository.findById(id);
            return equipamentoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                    ResponseEntity.notFound().build());
        }

        /**
         * Cria um novo equipamento.
         * @param estoque o novo equipamento.
         * @return o equipamento criado.
         */
        @PostMapping
        public Estoque createEquipamento(@RequestBody Estoque estoque) {
            return estoqueRepository.save(estoque);
        }

        /**
         * Atualiza um equipamento existente.
         * @param id o ID do equipamento a ser atualizado.
         * @param estoqueComDadosAtualizados os novos dados do equipamento.
         * @return o equipamento atualizado.
         */
        @PutMapping("/{id}")
        public ResponseEntity<Estoque> updateEquipamento(@PathVariable Long id,
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
         * Exclui um equipamento por ID.
         * @param id o ID do equipamento a ser excluído.
         * @return uma resposta indicando o sucesso ou falha da operação.
         */
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEquipamento(@PathVariable Long id) {
            Optional<Estoque> equipamentoParaDeletar = estoqueRepository.findById(id);
            if (equipamentoParaDeletar.isPresent()) {
                estoqueRepository.delete(equipamentoParaDeletar.get());
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

