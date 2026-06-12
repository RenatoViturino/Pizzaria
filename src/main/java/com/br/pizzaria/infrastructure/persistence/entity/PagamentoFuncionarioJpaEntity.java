package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade JPA: PagamentoFuncionario
 * PK: idPagamento (Long) — conforme diagrama de classes
 */
@Entity
@Table(name = "pagamentos_funcionarios")
public class PagamentoFuncionarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private FuncionarioJpaEntity funcionario;

    public Long getIdPagamento() { return idPagamento; }
    public void setIdPagamento(Long idPagamento) { this.idPagamento = idPagamento; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }

    public FuncionarioJpaEntity getFuncionario() { return funcionario; }
    public void setFuncionario(FuncionarioJpaEntity funcionario) { this.funcionario = funcionario; }
}
