package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compra_estoque")
public class CompraEstoqueJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "fornecedor", nullable = false)
    private String fornecedor;

    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    public CompraEstoqueJpaEntity() {}

    public Long getIdCompra() { return idCompra; }
    public void setIdCompra(Long idCompra) { this.idCompra = idCompra; }
    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    public LocalDate getDataCompra() { return dataCompra; }
    public void setDataCompra(LocalDate dataCompra) { this.dataCompra = dataCompra; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
}
