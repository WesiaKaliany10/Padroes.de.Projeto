package com.mycompany.academiaapi.service;

import com.mycompany.academiaapi.dto.pagamento.PagamentoDTO;
import com.mycompany.academiaapi.exception.ResourceNotFoundException;
import com.mycompany.academiaapi.model.Aluno;
import com.mycompany.academiaapi.model.Pagamento;
import com.mycompany.academiaapi.repository.AlunoRepository;
import com.mycompany.academiaapi.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service para Pagamento.
 * @author wesia
 */
@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final AlunoRepository alunoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, AlunoRepository alunoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public PagamentoDTO salvarPagamento(Long alunoId, Pagamento.FormaPagamento formaPagamento, LocalDateTime dataVencimento) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        if (aluno.getPlano() == null) throw new IllegalStateException("Aluno não possui plano associado.");

        Pagamento p = new Pagamento();
        p.setAluno(aluno);
        p.setValorPagamento(aluno.getPlano().getValorMensal());
        p.setDataPagamento(LocalDateTime.now());
        p.setFormaPagamento(formaPagamento);
        p.setStatusPagamento(p.getDataPagamento().isAfter(dataVencimento) ? Pagamento.StatusPagamento.ATRASADO : Pagamento.StatusPagamento.PAGO);
        p = pagamentoRepository.save(p);
        return toDto(p);
    }

    public List<PagamentoDTO> listarPagamentos() {
        return pagamentoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public PagamentoDTO consultar(Long id) {
        Pagamento p = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado"));
        return toDto(p);
    }

    public List<PagamentoDTO> listarPagamentosDoAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        return pagamentoRepository.findByAluno(aluno).stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<PagamentoDTO> listarPagamentosDoAlunoPorStatus(Long alunoId, Pagamento.StatusPagamento status) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        return pagamentoRepository.findByAlunoAndStatusPagamento(aluno, status).stream().map(this::toDto).collect(Collectors.toList());
    }

    private PagamentoDTO toDto(Pagamento p) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(p.getId());
        dto.setAlunoId(p.getAluno() != null ? p.getAluno().getId() : null);
        dto.setValorPagamento(p.getValorPagamento());
        dto.setDataPagamento(p.getDataPagamento());
        dto.setStatusPagamento(p.getStatusPagamento() != null ? p.getStatusPagamento().name() : null);
        dto.setFormaPagamento(p.getFormaPagamento() != null ? p.getFormaPagamento().name() : null);
        return dto;
    }
}
