package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CompraEstoque {

    private Long idCompra;
    private String fornecedor;
    private LocalDate dataCompra;
    private BigDecimal valorTotal;

    public CompraEstoque() {}

    public CompraEstoque(String fornecedor, LocalDate dataCompra, BigDecimal valorTotal) {
        this.fornecedor = fornecedor;
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
    }

    public Long getIdCompra() { return idCompra; }
    public void setIdCompra(Long idCompra) { this.idCompra = idCompra; }
    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    public LocalDate getDataCompra() { return dataCompra; }
    public void setDataCompra(LocalDate dataCompra) { this.dataCompra = dataCompra; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
}
