package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Qualidade;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.QualidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/qualidade")
public class QualidadeController {

    @Autowired
    private QualidadeRepository qualidadeRepository;

    /**
     * Obtém todas as qualidades.
     *
     * @return uma lista de qualidades.
     */
    @GetMapping
    public List<Qualidade> getAllQualidade() {
        return qualidadeRepository.findAll();
    }

    /**
     * Obtém uma qualidade por ID.
     *
     * @param id o ID da qualidade.
     * @return a qualidade com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Qualidade> getQualidadeById(@PathVariable Long id) {
        Optional<Qualidade> qualidadeBuscada = qualidadeRepository.findById(id);
        return qualidadeBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova qualidade.
     *
     * @param qualidade a nova qualidade.
     * @return a qualidade criada.
     */
    @PostMapping
    public Qualidade createQualidade(@RequestBody Qualidade qualidade) {
        return qualidadeRepository.save(qualidade);
    }

    /**
     * Atualiza uma qualidade existente.
     *
     * @param id                          o ID da qualidade a ser atualizada.
     * @param qualidadeComDadosAtualizados os novos dados da qualidade.
     * @return a qualidade atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Qualidade> updateQualidade(@PathVariable Long id,
                                                     @RequestBody Qualidade qualidadeComDadosAtualizados) {
        Optional<Qualidade> qualidadeExistente = qualidadeRepository.findById(id);
        if (qualidadeExistente.isPresent()) {
            qualidadeComDadosAtualizados.setIdInspecao(id);
            return ResponseEntity.ok(qualidadeRepository.save(qualidadeComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma qualidade por ID.
     *
     * @param id o ID da qualidade a ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualidade(@PathVariable Long id) {
        Optional<Qualidade> qualidadeParaDeletar = qualidadeRepository.findById(id);
        if (qualidadeParaDeletar.isPresent()) {
            qualidadeRepository.delete(qualidadeParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
