package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.valueobject.TipoMovimentoEstoque;

import java.time.LocalDateTime;

/**
 * Entidade de domínio: Estoque (movimentação)
 * PK gerada: idMovimento (Long)
 */
public class Estoque {

    private Long idMovimento;
    private TipoMovimentoEstoque tipoMovimento;
    private Integer quantidade;
    private LocalDateTime dataHora;
    private Long idProduto;

    public Estoque() {}

    public Estoque(TipoMovimentoEstoque tipoMovimento, Integer quantidade, Long idProduto) {
        this.tipoMovimento = tipoMovimento;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
        this.dataHora = LocalDateTime.now();
    }

    public Long getIdMovimento() { return idMovimento; }
    public void setIdMovimento(Long idMovimento) { this.idMovimento = idMovimento; }
    public TipoMovimentoEstoque getTipoMovimento() { return tipoMovimento; }
    public Integer getQuantidade() { return quantidade; }
    public LocalDateTime getDataHora() { return dataHora; }
    public Long getIdProduto() { return idProduto; }
}
