package com.mycompany.academiaapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidade Pagamento.
 * @author wesia
 */
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno; // pode ser null para avulso

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorPagamento;

    private LocalDateTime dataPagamento;

    public enum StatusPagamento { PAGO, PENDENTE, ATRASADO }

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    public enum FormaPagamento { DINHEIRO, PIX, CARTAO }

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public BigDecimal getValorPagamento() { return valorPagamento; }
    public void setValorPagamento(BigDecimal valorPagamento) { this.valorPagamento = valorPagamento; }

    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }

    public StatusPagamento getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(StatusPagamento statusPagamento) { this.statusPagamento = statusPagamento; }

    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(FormaPagamento formaPagamento) { this.formaPagamento = formaPagamento; }
}
