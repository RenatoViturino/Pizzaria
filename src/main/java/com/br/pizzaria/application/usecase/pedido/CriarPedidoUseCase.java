package com.br.pizzaria.application.usecase.pedido;

import com.br.pizzaria.application.dto.request.CriarPedidoRequest;
import com.br.pizzaria.application.dto.response.PedidoResponse;

/**
 * Caso de uso: Criar Pedido.
 */
public interface CriarPedidoUseCase {
    PedidoResponse executar(CriarPedidoRequest request);
}
