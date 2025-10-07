package com.mycompany.academiaapi.repository;

import com.mycompany.academiaapi.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para Plano.
 * @author wesia
 */
public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
