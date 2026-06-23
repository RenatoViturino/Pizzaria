package com.br.pizzaria.domain.valueobject;

/**
 * Value Object (enum): StatusPedido
 * Reflete o diagrama de estados: PENDENTE → CONFIRMADO → EM_PREPARO → SAIU_PARA_ENTREGA → ENTREGUE
 * Cancelamento permitido apenas nos estados iniciais.
 */
public enum StatusPedido {
    PENDENTE,
    CONFIRMADO,
    EM_PREPARO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO;

    /**
     * Valida se a transição para {@code destino} é permitida pelas regras de negócio.
     */
    public boolean podeTransicionarPara(StatusPedido destino) {
        return switch (this) {
            case PENDENTE          -> destino == CONFIRMADO  || destino == CANCELADO;
            case CONFIRMADO        -> destino == EM_PREPARO  || destino == CANCELADO;
            case EM_PREPARO        -> destino == SAIU_PARA_ENTREGA;
            case SAIU_PARA_ENTREGA -> destino == ENTREGUE;
            case ENTREGUE, CANCELADO -> false;
        };
    }
}
