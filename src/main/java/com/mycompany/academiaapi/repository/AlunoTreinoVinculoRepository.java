package com.mycompany.academiaapi.repository;

import com.mycompany.academiaapi.model.AlunoTreinoVinculo;
import com.mycompany.academiaapi.model.AlunoTreinoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository para AlunoTreinoVinculo.
 * @author wesia
 */
public interface AlunoTreinoVinculoRepository extends JpaRepository<AlunoTreinoVinculo, AlunoTreinoId> {

    @Query("SELECT v FROM AlunoTreinoVinculo v WHERE v.aluno.id = :alunoId")
    List<AlunoTreinoVinculo> findByAlunoId(@Param("alunoId") Long alunoId);

    @Query("SELECT v FROM AlunoTreinoVinculo v WHERE v.treino.id = :treinoId")
    List<AlunoTreinoVinculo> findByTreinoId(@Param("treinoId") Long treinoId);

    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM AlunoTreinoVinculo v WHERE v.aluno.id = :alunoId AND v.treino.id = :treinoId")
    boolean existsByAlunoIdAndTreinoId(@Param("alunoId") Long alunoId, @Param("treinoId") Long treinoId);
}
