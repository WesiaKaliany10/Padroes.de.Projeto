package com.mycompany.academiaapi.service;

import com.mycompany.academiaapi.dto.treino.TreinoDTO;
import com.mycompany.academiaapi.exception.BusinessRuleException;
import com.mycompany.academiaapi.exception.ResourceNotFoundException;
import com.mycompany.academiaapi.model.*;
import com.mycompany.academiaapi.repository.AlunoRepository;
import com.mycompany.academiaapi.repository.AlunoTreinoVinculoRepository;
import com.mycompany.academiaapi.repository.TreinoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service para Treino.
 * @author wesia
 */
@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final AlunoRepository alunoRepository;
    private final AlunoTreinoVinculoRepository vinculoRepository;

    public TreinoService(TreinoRepository treinoRepository, AlunoRepository alunoRepository, AlunoTreinoVinculoRepository vinculoRepository) {
        this.treinoRepository = treinoRepository;
        this.alunoRepository = alunoRepository;
        this.vinculoRepository = vinculoRepository;
    }

    @Transactional
    public TreinoDTO criarTreino(TreinoDTO dto) {
        Treino t = new Treino();
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(Treino.NivelTreino.valueOf(dto.getNivel()));
        t = treinoRepository.save(t);
        return toDto(t);
    }

    @Transactional
    public TreinoDTO atualizarTreino(Long id, TreinoDTO dto) {
        Treino t = treinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado"));
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(Treino.NivelTreino.valueOf(dto.getNivel()));
        t = treinoRepository.save(t);
        return toDto(t);
    }

    public List<TreinoDTO> listarTreinos() {
        return treinoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public TreinoDTO consultar(Long id) {
        Treino t = treinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado"));
        return toDto(t);
    }

    @Transactional
    public void removerTreino(Long id) {
        Treino t = treinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado"));
        if (!t.getVinculos().isEmpty()) {
            throw new BusinessRuleException("Não é possível remover treino com alunos vinculados");
        }
        treinoRepository.delete(t);
    }

    @Transactional
    public void vincularAluno(Long alunoId, Long treinoId) {
        if (vinculoRepository.existsByAlunoIdAndTreinoId(alunoId, treinoId)) {
            throw new BusinessRuleException("Aluno já vinculado a esse treino");
        }
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado"));
        AlunoTreinoVinculo vinculo = new AlunoTreinoVinculo();
        vinculo.setAluno(aluno);
        vinculo.setTreino(treino);
        vinculo.setDataAssociacao(LocalDateTime.now());
        vinculo.setId(new AlunoTreinoId(alunoId, treinoId));
        vinculoRepository.save(vinculo);
    }

    public List<AlunoTreinoVinculo> listarVinculosDoAluno(Long alunoId) {
        return vinculoRepository.findByAlunoId(alunoId);
    }

    public List<AlunoTreinoVinculo> listarVinculosDoTreino(Long treinoId) {
        return vinculoRepository.findByTreinoId(treinoId);
    }

    private TreinoDTO toDto(Treino t) {
        return new TreinoDTO(t.getId(), t.getNome(), t.getDescricao(), t.getNivel().name());
    }
}
