package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }
    public String getCpfFuncionario() { return cpfFuncionario; }
    public void setCpfFuncionario(String cpfFuncionario) { this.cpfFuncionario = cpfFuncionario; }
}
