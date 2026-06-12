package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;

public class ItemPedido {

    private Long idItem;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private Produto produto;

    public ItemPedido() {}

    public ItemPedido(Integer quantidade, BigDecimal precoUnitario, Produto produto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
    }

    public BigDecimal calcularSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getIdItem() { return idItem; }
    public void setIdItem(Long idItem) { this.idItem = idItem; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}
