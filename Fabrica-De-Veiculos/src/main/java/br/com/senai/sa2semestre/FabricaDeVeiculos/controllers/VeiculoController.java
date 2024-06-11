package br.com.senai.sa2semestre.FabricaDeVeiculos.controllers;

import br.com.senai.sa2semestre.FabricaDeVeiculos.entities.Veiculo;
import br.com.senai.sa2semestre.FabricaDeVeiculos.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    /**
     * Obtém todos os veículos.
     *
     * @return uma lista de veículos.
     */
    @GetMapping
    public List<Veiculo> getAllVeiculo() {
        return veiculoRepository.findAll();
    }

    /**
     * Obtém um veículo por ID.
     *
     * @param id o ID do veículo.
     * @return o veículo com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable String id) {
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(id);
        return veiculoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo veículo.
     *
     * @param veiculo o novo veículo.
     * @return o veículo criado.
     */
    @PostMapping
    public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    /**
     * Atualiza um veículo existente.
     *
     * @param id               o ID do veículo a ser atualizado.
     * @param veiculoAtualizado os novos dados do veículo.
     * @return o veículo atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable String id,
                                                 @RequestBody Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            veiculoAtualizado.setChassi(id);
            return ResponseEntity.ok(veiculoRepository.save(veiculoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um veículo por ID.
     *
     * @param id o ID do veículo a ser excluído.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable String id) {
        Optional<Veiculo> veiculoParaDeletar = veiculoRepository.findById(id);
        if (veiculoParaDeletar.isPresent()) {
            veiculoRepository.delete(veiculoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
