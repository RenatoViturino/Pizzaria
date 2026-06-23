package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.valueobject.StatusEntrega;

/**
 * Entidade de domínio: Entrega
 * PK: idEntrega (Long) — conforme diagrama de classes
 */
public class Entrega {

    private Long idEntrega;
    private String cpfFuncionario;
    private Long idPedido;
    private StatusEntrega statusEntrega;
    private Integer avaliacaoCliente;
    private Integer avaliacaoEntregador;

    public Entrega() {}

    /**
     * Construtor usado pelo EntregaService ao criar uma nova entrega.
     * Status inicia em PENDENTE conforme diagrama de estados.
     */
    public Entrega(String cpfFuncionario, Long idPedido) {
        this.cpfFuncionario  = cpfFuncionario;
        this.idPedido        = idPedido;
        this.statusEntrega   = StatusEntrega.AGUARDANDO;
    }

    public void registrarAvaliacaoCliente(Integer nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("Avaliação deve ser entre 1 e 5");
        this.avaliacaoCliente = nota;
    }

    public void registrarAvaliacaoEntregador(Integer nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("Avaliação deve ser entre 1 e 5");
        this.avaliacaoEntregador = nota;
    }

    public Long getIdEntrega()              { return idEntrega; }
    public void setIdEntrega(Long id)       { this.idEntrega = id; }
    public String getCpfFuncionario()       { return cpfFuncionario; }
    public void setCpfFuncionario(String v) { this.cpfFuncionario = v; }
    public Long getIdPedido()               { return idPedido; }
    public void setIdPedido(Long v)         { this.idPedido = v; }
    public StatusEntrega getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega s) { this.statusEntrega = s; }
    public Integer getAvaliacaoCliente()    { return avaliacaoCliente; }
    public void setAvaliacaoCliente(Integer v) { this.avaliacaoCliente = v; }
    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public void setAvaliacaoEntregador(Integer v) { this.avaliacaoEntregador = v; }
}
