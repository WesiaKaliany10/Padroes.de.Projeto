package com.mycompany.academiaapi.service;

import com.mycompany.academiaapi.dto.plano.PlanoDTO;
import com.mycompany.academiaapi.exception.ResourceNotFoundException;
import com.mycompany.academiaapi.model.Plano;
import com.mycompany.academiaapi.repository.PlanoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service para Plano (CRUD).
 * @author wesia
 */
@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Transactional
    public PlanoDTO criarPlano(PlanoDTO dto) {
        Plano p = new Plano();
        p.setNome(dto.getNome());
        p.setValorMensal(dto.getValorMensal());
        p.setDescricao(dto.getDescricao());
        p = planoRepository.save(p);
        return toDto(p);
    }

    public List<PlanoDTO> listarPlanos() {
        return planoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public PlanoDTO consultar(Long id) {
        Plano p = planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
        return toDto(p);
    }

    @Transactional
    public PlanoDTO atualizar(Long id, PlanoDTO dto) {
        Plano p = planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
        p.setNome(dto.getNome());
        p.setValorMensal(dto.getValorMensal());
        p.setDescricao(dto.getDescricao());
        p = planoRepository.save(p);
        return toDto(p);
    }

    @Transactional
    public void remover(Long id) {
        planoRepository.deleteById(id);
    }

    private PlanoDTO toDto(Plano p) {
        return new PlanoDTO(p.getId(), p.getNome(), p.getValorMensal(), p.getDescricao());
    }
}
