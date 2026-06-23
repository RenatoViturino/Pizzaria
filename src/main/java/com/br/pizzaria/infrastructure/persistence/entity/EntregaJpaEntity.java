package com.br.pizzaria.infrastructure.persistence.entity;

import com.br.pizzaria.domain.valueobject.StatusEntrega;
import jakarta.persistence.*;

/**
 * Entidade JPA: Entrega
 * Relacionada a PedidoJpaEntity (OneToOne) e EntregadorJpaEntity (ManyToOne).
 */
@Entity
@Table(name = "entregas")
public class EntregaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_entrega", nullable = false, length = 30)
    private StatusEntrega statusEntrega;

    @Column(name = "avaliacao_cliente")
    private Integer avaliacaoCliente;

    @Column(name = "avaliacao_entregador")
    private Integer avaliacaoEntregador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoJpaEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entregador", nullable = false)
    private EntregadorJpaEntity entregador;

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }
    public StatusEntrega getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega statusEntrega) { this.statusEntrega = statusEntrega; }
    public Integer getAvaliacaoCliente() { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer avaliacaoCliente) { this.avaliacaoCliente = avaliacaoCliente; }
    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer avaliacaoEntregador) { this.avaliacaoEntregador = avaliacaoEntregador; }
    public PedidoJpaEntity getPedido() { return pedido; }
    public void setPedido(PedidoJpaEntity pedido) { this.pedido = pedido; }
    public EntregadorJpaEntity getEntregador() { return entregador; }
    public void setEntregador(EntregadorJpaEntity entregador) { this.entregador = entregador; }
}
