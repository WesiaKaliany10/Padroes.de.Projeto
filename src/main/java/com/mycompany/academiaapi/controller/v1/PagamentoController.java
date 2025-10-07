package com.mycompany.academiaapi.controller.v1;

import com.mycompany.academiaapi.dto.pagamento.PagamentoDTO;
import com.mycompany.academiaapi.model.Pagamento;
import com.mycompany.academiaapi.service.PagamentoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller v1 para Pagamentos.
 * @author wesia
 */
@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;
    public PagamentoController(PagamentoService pagamentoService) { this.pagamentoService = pagamentoService; }

    @PostMapping("/{alunoId}")
    public ResponseEntity<PagamentoDTO> registrar(@PathVariable Long alunoId,
                                                  @RequestParam Pagamento.FormaPagamento formaPagamento,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataVencimento) {
        PagamentoDTO dto = pagamentoService.salvarPagamento(alunoId, formaPagamento, dataVencimento);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> listar() {
        return ResponseEntity.ok(pagamentoService.listarPagamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.consultar(id));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<PagamentoDTO>> listarDoAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(pagamentoService.listarPagamentosDoAluno(alunoId));
    }

    @GetMapping("/aluno/{alunoId}/status")
    public ResponseEntity<List<PagamentoDTO>> listarDoAlunoPorStatus(@PathVariable Long alunoId,
                                                                      @RequestParam Pagamento.StatusPagamento status) {
        return ResponseEntity.ok(pagamentoService.listarPagamentosDoAlunoPorStatus(alunoId, status));
    }
}
