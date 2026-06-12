package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade de domínio: PagamentoFuncionario
 * PK gerada: idPagamento (Long)
 */
public class PagamentoFuncionario {

    private Long idPagamento;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private String cpfFuncionario;

    public PagamentoFuncionario() {}

    public PagamentoFuncionario(BigDecimal valor, LocalDate dataPagamento, String cpfFuncionario) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.cpfFuncionario = cpfFuncionario;
    }

    public Long getIdPagamento() { return idPagamento; }
    public void setIdPagamento(Long idPagamento) { this.idPagamento = idPagamento; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public String getCpfFuncionario() { return cpfFuncionario; }
}
