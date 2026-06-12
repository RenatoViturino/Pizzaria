package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.exception.DomainException;

import java.math.BigDecimal;

/**
 * Entidade de domínio: ItemPedido
 * PK gerada: idItem (Long)
 */
public class ItemPedido {

    private Long idItem;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private Long idProduto;

    public ItemPedido() {}

    public ItemPedido(Long idProduto, Integer quantidade, BigDecimal precoUnitario) {
        if (quantidade == null || quantidade <= 0) {
            throw new DomainException("Quantidade do item deve ser maior que zero.");
        }
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new DomainException("Preço unitário deve ser positivo.");
        }
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getIdItem() { return idItem; }
    public void setIdItem(Long idItem) { this.idItem = idItem; }
    public Integer getQuantidade() { return quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public Long getIdProduto() { return idProduto; }
}
