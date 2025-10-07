package com.mycompany.academiaapi.controller.v1;

import com.mycompany.academiaapi.dto.plano.PlanoDTO;
import com.mycompany.academiaapi.service.PlanoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller v1 para Planos.
 * @author wesia
 */
@RestController
@RequestMapping("/api/v1/planos")
public class PlanoController {

    private final PlanoService planoService;
    public PlanoController(PlanoService planoService) { this.planoService = planoService; }

    @PostMapping
    public ResponseEntity<PlanoDTO> criar(@RequestBody PlanoDTO dto) {
        PlanoDTO criado = planoService.criarPlano(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> listar() {
        return ResponseEntity.ok(planoService.listarPlanos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(planoService.consultar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> atualizar(@PathVariable Long id, @RequestBody PlanoDTO dto) {
        return ResponseEntity.ok(planoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        planoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
