package com.mycompany.academiaapi.dto.aluno;

import java.time.LocalDate;

/**
 * DTO de resposta para Aluno.
 * @author wesia
 */
public class AlunoResponse {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private Long planoId;
    private boolean ativo;

    public AlunoResponse() {}
    public AlunoResponse(Long id, String nome, String cpf, String email, LocalDate dataNascimento, Long planoId, boolean ativo) {
        this.id = id; this.nome = nome; this.cpf = cpf; this.email = email; this.dataNascimento = dataNascimento; this.planoId = planoId; this.ativo = ativo;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public java.time.LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public Long getPlanoId() { return planoId; }
    public void setPlanoId(Long planoId) { this.planoId = planoId; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
