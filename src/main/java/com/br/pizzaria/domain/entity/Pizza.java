package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;

/**
 * Entidade de domínio: Pizza
 * Representa um item do cardápio conforme diagrama de classes.
 */
public class Pizza {

    private Long idPizza;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String tamanho;   // PEQUENA, MEDIA, GRANDE, FAMILIA
    private Boolean disponivel;

    public Pizza() {}

    public Pizza(String nome, String descricao, BigDecimal preco, String tamanho) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.disponivel = true;
    }

    public Long getIdPizza() { return idPizza; }
    public void setIdPizza(Long idPizza) { this.idPizza = idPizza; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
