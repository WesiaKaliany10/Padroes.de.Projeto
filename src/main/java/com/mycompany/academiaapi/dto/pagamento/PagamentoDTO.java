package com.mycompany.academiaapi.dto.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO para Pagamento.
 * @author wesia
 */
public class PagamentoDTO {
    private Long id;
    private Long alunoId;
    private BigDecimal valorPagamento;
    private LocalDateTime dataPagamento;
    private String statusPagamento;
    private String formaPagamento;

    public PagamentoDTO() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public BigDecimal getValorPagamento() { return valorPagamento; }
    public void setValorPagamento(BigDecimal valorPagamento) { this.valorPagamento = valorPagamento; }
    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }
    public String getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}
