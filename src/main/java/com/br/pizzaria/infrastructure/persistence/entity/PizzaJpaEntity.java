package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Entidade JPA de Pizza (cardápio).
 */
@Entity
@Table(name = "pizzas")
public class PizzaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String tamanho;
}
