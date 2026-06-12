package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;

public class Produto {

    private Long idProduto;
    private String nome;
    private String tipo;
    private BigDecimal preco;
    private Integer estoqueAtual;

    public Produto() {}

    public Produto(String nome, String tipo, BigDecimal preco, Integer estoqueAtual) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
    }

    public Long getIdProduto() { return idProduto; }
    public void setIdProduto(Long idProduto) { this.idProduto = idProduto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public Integer getEstoqueAtual() { return estoqueAtual; }
    public void setEstoqueAtual(Integer estoqueAtual) { this.estoqueAtual = estoqueAtual; }
}
