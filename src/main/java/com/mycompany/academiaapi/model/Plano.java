package com.mycompany.academiaapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entidade Plano.
 * @author wesia
 */
@Entity
@Table(name = "planos")
public class Plano {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorMensal;

    private String descricao;

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
