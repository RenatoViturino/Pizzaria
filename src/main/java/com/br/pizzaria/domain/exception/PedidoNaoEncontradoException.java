package com.br.pizzaria.domain.exception;

/**
 * Exceção: Pedido não encontrado pelo ID.
 */
public class PedidoNaoEncontradoException extends DomainException {

    public PedidoNaoEncontradoException(Long idPedido) {
        super("Pedido não encontrado com id: " + idPedido);
    }
}
