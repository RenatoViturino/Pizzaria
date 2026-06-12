package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.exception.DomainException;

import java.math.BigDecimal;

/**
 * Entidade de domínio: Produto
 * PK gerada: idProduto (Long)
 */
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

    public void reduzirEstoque(int quantidade) {
        if (this.estoqueAtual < quantidade) {
            throw new DomainException("Estoque insuficiente para o produto: " + nome);
        }
        this.estoqueAtual -= quantidade;
    }

    public void aumentarEstoque(int quantidade) {
        this.estoqueAtual += quantidade;
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
}
