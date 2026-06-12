package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.AtualizarStatusPedidoRequest;
import com.br.pizzaria.application.dto.response.PedidoResponse;

public interface AtualizarStatusPedidoUseCase {
    PedidoResponse executar(AtualizarStatusPedidoRequest request);
}
