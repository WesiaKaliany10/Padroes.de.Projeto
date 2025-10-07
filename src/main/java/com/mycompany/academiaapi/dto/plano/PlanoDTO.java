package com.mycompany.academiaapi.dto.plano;

import java.math.BigDecimal;

/**
 * DTO para Plano.
 * @author wesia
 */
public class PlanoDTO {
    private Long id;
    private String nome;
    private BigDecimal valorMensal;
    private String descricao;

    public PlanoDTO() {}
    public PlanoDTO(Long id, String nome, BigDecimal valorMensal, String descricao) {
        this.id = id; this.nome = nome; this.valorMensal = valorMensal; this.descricao = descricao;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getValorMensal() { return valorMensal; }
    public void setValorMensal(BigDecimal valorMensal) { this.valorMensal = valorMensal; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
