package com.mycompany.academiaapi.controller.v1;

import com.mycompany.academiaapi.dto.aluno.AlunoRequest;
import com.mycompany.academiaapi.dto.aluno.AlunoResponse;
import com.mycompany.academiaapi.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller v1 para Aluno. Versioned API /api/v1.
 * @author wesia
 */
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) { this.alunoService = alunoService; }

    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@Valid @RequestBody AlunoRequest req) {
        AlunoResponse created = alunoService.cadastrarAluno(req);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.consultarAluno(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AlunoRequest req) {
        return ResponseEntity.ok(alunoService.atualizarAluno(id, req));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        alunoService.inativarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
