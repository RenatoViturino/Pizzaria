package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entrega")
public class EntregaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    @Column(name = "status_entrega", nullable = false, length = 20)
    private String statusEntrega;

    @Column(name = "avaliacao_cliente")
    private Integer avaliacaoCliente;

    @Column(name = "avaliacao_entregador")
    private Integer avaliacaoEntregador;

    @Column(name = "cpf_funcionario", nullable = false, length = 11)
    private String cpfFuncionario;

    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;

    public EntregaJpaEntity() {}

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }
    public String getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(String statusEntrega) { this.statusEntrega = statusEntrega; }
    public Integer getAvaliacaoCliente() { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer avaliacaoCliente) { this.avaliacaoCliente = avaliacaoCliente; }
    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer avaliacaoEntregador) { this.avaliacaoEntregador = avaliacaoEntregador; }
    public String getCpfFuncionario() { return cpfFuncionario; }
    public void setCpfFuncionario(String cpfFuncionario) { this.cpfFuncionario = cpfFuncionario; }
    public Long getIdPedido() { return idPedido; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }
}
