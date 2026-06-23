package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.exception.DomainException;
import com.br.pizzaria.domain.valueobject.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entidade de domínio: Pedido
 * PK gerada: idPedido (Long)
 */
public class Pedido {

    private Long idPedido;
    private LocalDateTime dataHora;
    private StatusPedido status;
    private BigDecimal valorTotal;
    private String cpfCliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {}

    public Pedido(String cpfCliente, List<ItemPedido> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new DomainException("Pedido deve conter ao menos um item.");
        }
        this.cpfCliente = cpfCliente;
        this.itens = new ArrayList<>(itens);
        this.dataHora = LocalDateTime.now();
        this.status = StatusPedido.CRIADO;   // estado inicial conforme diagrama
        this.valorTotal = calcularTotal();
    }

    private BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Atualiza o status do pedido validando a transição conforme o diagrama de estado.
     */
    public void atualizarStatus(StatusPedido novoStatus) {
        if (!this.status.podeTransicionarPara(novoStatus)) {
            throw new DomainException(
                String.format("Transição de status inválida: %s → %s", this.status, novoStatus)
            );
        }
        this.status = novoStatus;
    }

    public Long getIdPedido() { return idPedido; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }
    public LocalDateTime getDataHora() { return dataHora; }
    public StatusPedido getStatus() { return status; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public String getCpfCliente() { return cpfCliente; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itens); }
}
