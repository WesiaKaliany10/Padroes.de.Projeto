package com.mycompany.academiaapi.controller.v1;

import com.mycompany.academiaapi.dto.treino.TreinoDTO;
import com.mycompany.academiaapi.model.AlunoTreinoVinculo;
import com.mycompany.academiaapi.dto.vinculo.AlunoTreinoVinculoDTO;
import com.mycompany.academiaapi.service.TreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller v1 para Treinos.
 * @author wesia
 */
@RestController
@RequestMapping("/api/v1/treinos")
public class TreinoController {

    private final TreinoService treinoService;
    public TreinoController(TreinoService treinoService) { this.treinoService = treinoService; }

    @PostMapping
    public ResponseEntity<TreinoDTO> criar(@RequestBody TreinoDTO dto) {
        return ResponseEntity.status(201).body(treinoService.criarTreino(dto));
    }

    @GetMapping
    public ResponseEntity<List<TreinoDTO>> listar() {
        return ResponseEntity.ok(treinoService.listarTreinos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(treinoService.consultar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoDTO> atualizar(@PathVariable Long id, @RequestBody TreinoDTO dto) {
        return ResponseEntity.ok(treinoService.atualizarTreino(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        treinoService.removerTreino(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/vincular")
    public ResponseEntity<Void> vincular(@RequestParam Long alunoId, @RequestParam Long treinoId) {
        treinoService.vincularAluno(alunoId, treinoId);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/aluno/{alunoId}/vinculos")
    public ResponseEntity<List<AlunoTreinoVinculoDTO>> listarVinculosDoAluno(@PathVariable Long alunoId) {
        List<AlunoTreinoVinculo> lista = treinoService.listarVinculosDoAluno(alunoId);
        List<AlunoTreinoVinculoDTO> dto = lista.stream().map(v -> {
            AlunoTreinoVinculoDTO d = new AlunoTreinoVinculoDTO();
            d.setAlunoId(v.getAluno().getId());
            d.setAlunoNome(v.getAluno().getNome());
            d.setTreinoId(v.getTreino().getId());
            d.setTreinoNome(v.getTreino().getNome());
            d.setDataAssociacao(v.getDataAssociacao());
            return d;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{treinoId}/vinculos")
    public ResponseEntity<List<AlunoTreinoVinculoDTO>> listarVinculosDoTreino(@PathVariable Long treinoId) {
        List<AlunoTreinoVinculo> lista = treinoService.listarVinculosDoTreino(treinoId);
        List<AlunoTreinoVinculoDTO> dto = lista.stream().map(v -> {
            AlunoTreinoVinculoDTO d = new AlunoTreinoVinculoDTO();
            d.setAlunoId(v.getAluno().getId());
            d.setAlunoNome(v.getAluno().getNome());
            d.setTreinoId(v.getTreino().getId());
            d.setTreinoNome(v.getTreino().getNome());
            d.setDataAssociacao(v.getDataAssociacao());
            return d;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}
