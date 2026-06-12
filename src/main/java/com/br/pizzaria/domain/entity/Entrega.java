package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.valueobject.StatusEntrega;

/**
 * Entidade de domínio: Entrega
 * PK gerada: idEntrega (Long)
 */
public class Entrega {

    private Long idEntrega;
    private StatusEntrega statusEntrega;
    private Integer avaliacaoCliente;
    private Integer avaliacaoEntregador;
    private String cpfFuncionario;
    private Long idPedido;

    public Entrega() {}

    public Entrega(String cpfFuncionario, Long idPedido) {
        this.cpfFuncionario = cpfFuncionario;
        this.idPedido = idPedido;
        this.statusEntrega = StatusEntrega.AGUARDANDO;
    }

    public void registrarAvaliacaoCliente(int nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("Nota deve ser entre 1 e 5.");
        this.avaliacaoCliente = nota;
    }

    public void registrarAvaliacaoEntregador(int nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("Nota deve ser entre 1 e 5.");
        this.avaliacaoEntregador = nota;
    }

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }
    public StatusEntrega getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega statusEntrega) { this.statusEntrega = statusEntrega; }
    public Integer getAvaliacaoCliente() { return avaliacaoCliente; }
    public Integer getAvaliacaoEntregador() { return avaliacaoEntregador; }
    public String getCpfFuncionario() { return cpfFuncionario; }
    public Long getIdPedido() { return idPedido; }
}
