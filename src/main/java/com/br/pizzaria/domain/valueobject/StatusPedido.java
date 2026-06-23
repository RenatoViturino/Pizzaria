package com.br.pizzaria.domain.valueobject;

/**
 * Value Object (enum): StatusPedido
 *
 * Estados alinhados ao diagrama de estado:
 *   Criado → Pago → EmPreparacao → Pronto → EmEntrega → Concluido → Avaliado
 *   Cancelado pode ocorrer de: Criado, Pago, EmPreparacao (via cancelamento cliente/sistema)
 *   EmEntrega → Cancelado (via falha na entrega)
 */
public enum StatusPedido {
    CRIADO,
    PAGO,
    EM_PREPARACAO,
    PRONTO,
    EM_ENTREGA,
    CONCLUIDO,
    AVALIADO,
    CANCELADO;

    /**
     * Valida se a transição para {@code destino} é permitida pelas regras do diagrama de estado.
     */
    public boolean podeTransicionarPara(StatusPedido destino) {
        return switch (this) {
            case CRIADO        -> destino == PAGO        || destino == CANCELADO;
            case PAGO          -> destino == EM_PREPARACAO || destino == CANCELADO;
            case EM_PREPARACAO -> destino == PRONTO      || destino == CANCELADO;
            case PRONTO        -> destino == EM_ENTREGA;
            case EM_ENTREGA    -> destino == CONCLUIDO   || destino == CANCELADO;
            case CONCLUIDO     -> destino == AVALIADO;
            case AVALIADO, CANCELADO -> false;
        };
    }
}
