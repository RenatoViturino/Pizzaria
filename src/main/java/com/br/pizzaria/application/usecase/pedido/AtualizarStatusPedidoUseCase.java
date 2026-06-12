package com.br.pizzaria.application.usecase.pedido;

import com.br.pizzaria.application.dto.request.AtualizarStatusPedidoRequest;
import com.br.pizzaria.application.dto.response.PedidoResponse;

/**
 * Caso de uso: Atualizar status do Pedido.
 */
public interface AtualizarStatusPedidoUseCase {
    PedidoResponse executar(AtualizarStatusPedidoRequest request);
}
