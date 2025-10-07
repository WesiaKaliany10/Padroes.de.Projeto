package com.mycompany.academiaapi.repository;

import com.mycompany.academiaapi.model.Pagamento;
import com.mycompany.academiaapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository para Pagamento.
 * @author wesia
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByAluno(Aluno aluno);
    List<Pagamento> findByAlunoAndStatusPagamento(Aluno aluno, Pagamento.StatusPagamento statusPagamento);
}
