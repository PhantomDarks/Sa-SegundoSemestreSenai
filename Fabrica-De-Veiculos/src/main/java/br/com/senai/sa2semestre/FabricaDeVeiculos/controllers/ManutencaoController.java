package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Manutencao;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    /**
     * Obtém todas as manutenções.
     *
     * @return uma lista de manutenções.
     */
    @GetMapping
    public List<Manutencao> getAllManutencao() {
        return manutencaoRepository.findAll();
    }

    /**
     * Obtém uma manutenção por ID.
     *
     * @param id o ID da manutenção.
     * @return a manutenção com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getManutencaoById(@PathVariable Long id) {
        Optional<Manutencao> manutencaoBuscada = manutencaoRepository.findById(id);
        return manutencaoBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova manutenção.
     *
     * @param manutencao a nova manutenção.
     * @return a manutenção criada.
     */
    @PostMapping
    public Manutencao createManutencao(@RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    /**
     * Atualiza uma manutenção existente.
     *
     * @param id                             o ID da manutenção a ser atualizada.
     * @param manutencaoComDadosAtualizados os novos dados da manutenção.
     * @return a manutenção atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> updateManutencao(@PathVariable Long id,
                                                       @RequestBody Manutencao manutencaoComDadosAtualizados) {
        Optional<Manutencao> manutencaoExistente = manutencaoRepository.findById(id);
        if (manutencaoExistente.isPresent()) {
            manutencaoComDadosAtualizados.setIdManutencao(id);
            return ResponseEntity.ok(manutencaoRepository.save(manutencaoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma manutenção por ID.
     *
     * @param id o ID da manutenção a ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManutencao(@PathVariable Long id) {
        Optional<Manutencao> manutencaoParaDeletar = manutencaoRepository.findById(id);
        if (manutencaoParaDeletar.isPresent()) {
            manutencaoRepository.delete(manutencaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
