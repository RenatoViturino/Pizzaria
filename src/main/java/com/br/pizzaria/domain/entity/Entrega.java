package com.br.pizzaria.domain.entity;

/**
 * Entidade de domínio: Entrega
 * PK: idEntrega (Long) — conforme diagrama de classes
 * Referencia Entregador (especialização de Funcionario) diretamente.
 */
public class Entrega {

    private Long idEntrega;
    private StatusEntrega statusEntrega;  // era String — substituído por enum tipado
    private Integer avaliacaoCliente;
    private Integer avaliacaoEntregador;
    private Entregador entregador;  // era Funcionario genérico — corrigido para Entregador

    public Entrega() {}

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }

    public StatusEntrega getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega statusEntrega) { this.statusEntrega = statusEntrega; }

    public Integer getAvaliacaoCliente() { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer avaliacaoCliente) { this.avaliacaoCliente = avaliacaoCliente; }

    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer avaliacaoEntregador) { this.avaliacaoEntregador = avaliacaoEntregador; }

    public Entregador getEntregador() { return entregador; }
    public void setEntregador(Entregador entregador) { this.entregador = entregador; }
}
