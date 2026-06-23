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
    private String cpfEntregador;   // renomeado de cpfFuncionario — Entrega é responsabilidade do Entregador
    private Long idPedido;

    public Entrega() {}

    public Entrega(String cpfEntregador, Long idPedido) {
        if (cpfEntregador == null || cpfEntregador.isBlank())
            throw new IllegalArgumentException("CPF do entregador é obrigatório.");
        if (idPedido == null)
            throw new IllegalArgumentException("idPedido é obrigatório.");
        this.cpfEntregador = cpfEntregador;
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

    public void avancarStatus(StatusEntrega novoStatus) {
        if (this.statusEntrega == StatusEntrega.ENTREGUE)
            throw new IllegalStateException("Entrega já finalizada.");
        this.statusEntrega = novoStatus;
    }

    public Long getIdEntrega()                          { return idEntrega; }
    public void setIdEntrega(Long idEntrega)             { this.idEntrega = idEntrega; }
    public StatusEntrega getStatusEntrega()             { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega s)       { this.statusEntrega = s; }
    public Integer getAvaliacaoCliente()                { return avaliacaoCliente; }
    public Integer getAvaliacaoEntregador()             { return avaliacaoEntregador; }
    public String getCpfEntregador()                    { return cpfEntregador; }
    public Long getIdPedido()                           { return idPedido; }
}
