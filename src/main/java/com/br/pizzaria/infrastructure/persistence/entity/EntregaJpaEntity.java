package com.br.pizzaria.infrastructure.persistence.entity;

import com.br.pizzaria.domain.valueobject.StatusEntrega;
import jakarta.persistence.*;

/**
 * Entidade JPA: Entrega
 * cpfFuncionario e idPedido como colunas simples (sem @ManyToOne/@OneToOne)
 * para alinhar com o domínio que trabalha com IDs escalares.
 */
@Entity
@Table(name = "entregas")
public class EntregaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    @Column(name = "cpf_funcionario", nullable = false, length = 14)
    private String cpfFuncionario;

    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_entrega", nullable = false, length = 30)
    private StatusEntrega statusEntrega;

    @Column(name = "avaliacao_cliente")
    private Integer avaliacaoCliente;

    @Column(name = "avaliacao_entregador")
    private Integer avaliacaoEntregador;

    public Long getIdEntrega()                    { return idEntrega; }
    public void setIdEntrega(Long v)              { this.idEntrega = v; }
    public String getCpfFuncionario()             { return cpfFuncionario; }
    public void setCpfFuncionario(String v)       { this.cpfFuncionario = v; }
    public Long getIdPedido()                     { return idPedido; }
    public void setIdPedido(Long v)               { this.idPedido = v; }
    public StatusEntrega getStatusEntrega()       { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega v) { this.statusEntrega = v; }
    public Integer getAvaliacaoCliente()          { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer v)    { this.avaliacaoCliente = v; }
    public Integer getAvaliacaoEntregador()       { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer v) { this.avaliacaoEntregador = v; }
}
