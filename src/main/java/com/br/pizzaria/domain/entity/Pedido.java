package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade de domínio: Pedido
 * PK: idPedido (Long) — conforme diagrama de classes
 */
public class Pedido {

    private Long idPedido;
    private LocalDateTime dataHora;
    private StatusPedido status;  // era String — substituído por enum tipado
    private BigDecimal valorTotal;
    private String cpfCliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private Entrega entrega;

    public Pedido() {}

    public Pedido(String cpfCliente) {
        this.cpfCliente = cpfCliente;
        this.dataHora = LocalDateTime.now();
        this.status = StatusPedido.RECEBIDO;
        this.valorTotal = BigDecimal.ZERO;
    }

    /**
     * Realiza transição de status validando as regras do diagrama de estados.
     * Lança IllegalStateException se a transição não for permitida.
     */
    public void atualizarStatus(StatusPedido novoStatus) {
        if (!this.status.podeTransicionarPara(novoStatus)) {
            throw new IllegalStateException(
                "Transição inválida: %s → %s".formatted(this.status, novoStatus)
            );
        }
        this.status = novoStatus;
    }

    public Long getIdPedido() { return idPedido; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public List<ItemPedido> getItens() { return itens; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }

    public Entrega getEntrega() { return entrega; }
    public void setEntrega(Entrega entrega) { this.entrega = entrega; }
}
