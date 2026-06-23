package com.br.pizzaria.domain.entity;

/**
 * Enum de status do pedido — conforme diagrama de estados.
 * Substitui o campo String status em Pedido e PedidoJpaEntity.
 */
public enum StatusPedido {

    RECEBIDO,
    EM_PREPARO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO;

    /**
     * Valida se a transição para o próximo status é permitida.
     * Segue o fluxo do diagrama de estados: RECEBIDO → EM_PREPARO → SAIU_PARA_ENTREGA → ENTREGUE
     * CANCELADO pode ser acionado a partir de RECEBIDO ou EM_PREPARO.
     */
    public boolean podeTransicionarPara(StatusPedido proximo) {
        return switch (this) {
            case RECEBIDO         -> proximo == EM_PREPARO   || proximo == CANCELADO;
            case EM_PREPARO       -> proximo == SAIU_PARA_ENTREGA || proximo == CANCELADO;
            case SAIU_PARA_ENTREGA -> proximo == ENTREGUE;
            case ENTREGUE, CANCELADO -> false;
        };
    }
}
