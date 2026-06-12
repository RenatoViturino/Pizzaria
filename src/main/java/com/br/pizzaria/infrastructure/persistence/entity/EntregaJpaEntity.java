package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;

/**
 * Entidade JPA: Entrega
 * PK: idEntrega (Long) — conforme diagrama de classes
 */
@Entity
@Table(name = "entregas")
public class EntregaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    @Column(name = "status_entrega", nullable = false, length = 30)
    private String statusEntrega;

    @Column(name = "avaliacao_cliente")
    private Integer avaliacaoCliente;

    @Column(name = "avaliacao_entregador")
    private Integer avaliacaoEntregador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoJpaEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private FuncionarioJpaEntity funcionario;

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }

    public String getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(String statusEntrega) { this.statusEntrega = statusEntrega; }

    public Integer getAvaliacaoCliente() { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer avaliacaoCliente) { this.avaliacaoCliente = avaliacaoCliente; }

    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer avaliacaoEntregador) { this.avaliacaoEntregador = avaliacaoEntregador; }

    public PedidoJpaEntity getPedido() { return pedido; }
    public void setPedido(PedidoJpaEntity pedido) { this.pedido = pedido; }

    public FuncionarioJpaEntity getFuncionario() { return funcionario; }
    public void setFuncionario(FuncionarioJpaEntity funcionario) { this.funcionario = funcionario; }
}
