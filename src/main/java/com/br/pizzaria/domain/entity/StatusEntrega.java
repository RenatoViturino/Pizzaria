package com.br.pizzaria.domain.entity;

/**
 * Enum de status da entrega — conforme diagrama de estados.
 * Substitui o campo String statusEntrega em Entrega e EntregaJpaEntity.
 */
public enum StatusEntrega {
    AGUARDANDO_ENTREGADOR,
    EM_ROTA,
    ENTREGUE,
    FALHA_NA_ENTREGA
}
