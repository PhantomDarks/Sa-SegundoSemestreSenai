package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Producao;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

    @Autowired
    private ProducaoRepository producaoRepository;

    /**
     * Obtém todas as produções.
     *
     * @return uma lista de produções.
     */
    @GetMapping
    public List<Producao> getAllProducao() {
        return producaoRepository.findAll();
    }

    /**
     * Obtém uma produção por ID.
     *
     * @param id o ID da produção.
     * @return a produção com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producao> getProducaoById(@PathVariable Long id) {
        Optional<Producao> producaoBuscada = producaoRepository.findById(id);
        return producaoBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova produção.
     *
     * @param producao a nova produção.
     * @return a produção criada.
     */
    @PostMapping
    public Producao createProducao(@RequestBody Producao producao) {
        return producaoRepository.save(producao);
    }

    /**
     * Atualiza uma produção existente.
     *
     * @param id                       o ID da produção a ser atualizada.
     * @param producaoComDadosAtualizados os novos dados da produção.
     * @return a produção atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producao> updateProducao(@PathVariable Long id,
                                                   @RequestBody Producao producaoComDadosAtualizados) {
        Optional<Producao> producaoExistente = producaoRepository.findById(id);
        if (producaoExistente.isPresent()) {
            producaoComDadosAtualizados.setIdProducao(id);
            return ResponseEntity.ok(producaoRepository.save(producaoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma produção por ID.
     *
     * @param id o ID da produção a ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducao(@PathVariable Long id) {
        Optional<Producao> producaoParaDeletar = producaoRepository.findById(id);
        if (producaoParaDeletar.isPresent()) {
            producaoRepository.delete(producaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
