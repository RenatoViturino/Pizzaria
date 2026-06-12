package com.br.pizzaria.infrastructure.persistence.entity;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * Entidade JPA de Pedido.
 */
@Entity
@Table(name = "pedidos")
public class PedidoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cliente_id", nullable = false)
    private UUID clienteId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    @Column(name = "criado_em", nullable = false)
    private Instant criadoEm;

    // TODO: relacionamento com ItemPedidoJpaEntity
}
