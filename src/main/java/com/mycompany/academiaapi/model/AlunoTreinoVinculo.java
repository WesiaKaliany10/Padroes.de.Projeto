package com.mycompany.academiaapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidade de vínculo Aluno-Treino com ID composto.
 * @author wesia
 */
@Entity
@Table(name = "aluno_treino_vinculo")
public class AlunoTreinoVinculo {

    @EmbeddedId
    private AlunoTreinoId id = new AlunoTreinoId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("treinoId")
    @JoinColumn(name = "treino_id")
    private Treino treino;

    private LocalDateTime dataAssociacao;

    // getters/setters
    public AlunoTreinoId getId() { return id; }
    public void setId(AlunoTreinoId id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }

    public LocalDateTime getDataAssociacao() { return dataAssociacao; }
    public void setDataAssociacao(LocalDateTime dataAssociacao) { this.dataAssociacao = dataAssociacao; }
}
