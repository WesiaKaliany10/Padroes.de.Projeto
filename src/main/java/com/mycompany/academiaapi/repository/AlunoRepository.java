package com.mycompany.academiaapi.repository;

import com.mycompany.academiaapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para Aluno.
 * @author wesia
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByCpf(String cpf);
}
