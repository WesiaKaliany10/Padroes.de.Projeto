package com.mycompany.academiaapi.repository;

import com.mycompany.academiaapi.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para Treino.
 * @author wesia
 */
public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
