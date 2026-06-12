package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarPedidoRequest;
import com.br.pizzaria.application.dto.response.PedidoResponse;

public interface CriarPedidoUseCase {
    PedidoResponse executar(CriarPedidoRequest request);
}
