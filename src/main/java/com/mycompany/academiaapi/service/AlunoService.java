package com.mycompany.academiaapi.service;

import com.mycompany.academiaapi.dto.aluno.AlunoRequest;
import com.mycompany.academiaapi.dto.aluno.AlunoResponse;
import com.mycompany.academiaapi.exception.BusinessRuleException;
import com.mycompany.academiaapi.exception.ResourceNotFoundException;
import com.mycompany.academiaapi.model.Aluno;
import com.mycompany.academiaapi.model.Plano;
import com.mycompany.academiaapi.repository.AlunoRepository;
import com.mycompany.academiaapi.repository.PlanoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service para Aluno (regras de negócio).
 * @author wesia
 */
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;

    public AlunoService(AlunoRepository alunoRepository, PlanoRepository planoRepository) {
        this.alunoRepository = alunoRepository;
        this.planoRepository = planoRepository;
    }

    @Transactional
    public AlunoResponse cadastrarAluno(AlunoRequest req) {
        if (alunoRepository.existsByCpf(req.getCpf())) {
            throw new BusinessRuleException("CPF já cadastrado.");
        }
        Aluno a = new Aluno();
        a.setNome(req.getNome());
        a.setCpf(req.getCpf());
        a.setEmail(req.getEmail());
        a.setDataNascimento(req.getDataNascimento());
        if (req.getPlanoId() != null) {
            Plano plano = planoRepository.findById(req.getPlanoId()).orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
            a.setPlano(plano);
        }
        a = alunoRepository.save(a);
        return toResponse(a);
    }

    @Transactional(readOnly = true)
    public AlunoResponse consultarAluno(Long id) {
        Aluno a = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        return toResponse(a);
    }

    @Transactional
    public AlunoResponse atualizarAluno(Long id, AlunoRequest req) {
        Aluno a = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        a.setNome(req.getNome());
        a.setEmail(req.getEmail());
        a.setDataNascimento(req.getDataNascimento());
        // Não altera CPF
        if (req.getPlanoId() != null) {
            Plano plano = planoRepository.findById(req.getPlanoId()).orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
            a.setPlano(plano);
        } else {
            a.setPlano(null);
        }
        a = alunoRepository.save(a);
        return toResponse(a);
    }

    @Transactional
    public void inativarAluno(Long id) {
        Aluno a = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        a.setAtivo(false);
        alunoRepository.save(a);
    }

    private AlunoResponse toResponse(Aluno a) {
        Long planoId = a.getPlano() != null ? a.getPlano().getId() : null;
        return new AlunoResponse(a.getId(), a.getNome(), a.getCpf(), a.getEmail(), a.getDataNascimento(), planoId, a.isAtivo());
    }
}
