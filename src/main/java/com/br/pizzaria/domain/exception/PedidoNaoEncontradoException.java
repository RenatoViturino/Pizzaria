package com.br.pizzaria.domain.exception;

import java.util.UUID;

public class PedidoNaoEncontradoException extends DomainException {
    public PedidoNaoEncontradoException(UUID id) {
        super("Pedido não encontrado: " + id);
    }
}
