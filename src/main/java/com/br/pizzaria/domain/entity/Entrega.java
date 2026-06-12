package com.br.pizzaria.domain.entity;

/**
 * Entidade de domínio: Entrega
 * PK: idEntrega (Long) — conforme diagrama de classes
 */
public class Entrega {

    private Long idEntrega;
    private String statusEntrega;
    private Integer avaliacaoCliente;
    private Integer avaliacaoEntregador;
    private Funcionario funcionario;

    public Entrega() {}

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }

    public String getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(String statusEntrega) { this.statusEntrega = statusEntrega; }

    public Integer getAvaliacaoCliente() { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer avaliacaoCliente) { this.avaliacaoCliente = avaliacaoCliente; }

    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer avaliacaoEntregador) { this.avaliacaoEntregador = avaliacaoEntregador; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
}
