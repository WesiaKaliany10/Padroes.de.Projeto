package com.mycompany.academiaapi.dto.vinculo;

import java.time.LocalDateTime;

/**
 * DTO para Vinculo Aluno-Treino.
 * @author wesia
 */
public class AlunoTreinoVinculoDTO {
    private Long alunoId;
    private String alunoNome;
    private Long treinoId;
    private String treinoNome;
    private LocalDateTime dataAssociacao;

    public AlunoTreinoVinculoDTO() {}

    // getters/setters
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public String getAlunoNome() { return alunoNome; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }
    public Long getTreinoId() { return treinoId; }
    public void setTreinoId(Long treinoId) { this.treinoId = treinoId; }
    public String getTreinoNome() { return treinoNome; }
    public void setTreinoNome(String treinoNome) { this.treinoNome = treinoNome; }
    public LocalDateTime getDataAssociacao() { return dataAssociacao; }
    public void setDataAssociacao(LocalDateTime dataAssociacao) { this.dataAssociacao = dataAssociacao; }
}
