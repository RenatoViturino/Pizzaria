package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidade JPA: Estoque (movimentação)
 * PK: idMovimento (Long) — conforme diagrama de classes
 */
@Entity
@Table(name = "estoque")
public class EstoqueJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimento")
    private Long idMovimento;

    @Column(name = "tipo_movimento", nullable = false, length = 20)
    private String tipoMovimento;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoJpaEntity produto;

    public Long getIdMovimento() { return idMovimento; }
    public void setIdMovimento(Long idMovimento) { this.idMovimento = idMovimento; }

    public String getTipoMovimento() { return tipoMovimento; }
    public void setTipoMovimento(String tipoMovimento) { this.tipoMovimento = tipoMovimento; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public ProdutoJpaEntity getProduto() { return produto; }
    public void setProduto(ProdutoJpaEntity produto) { this.produto = produto; }
}
