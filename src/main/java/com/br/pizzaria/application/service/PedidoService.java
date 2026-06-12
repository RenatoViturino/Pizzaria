package com.br.pizzaria.application.service;

import com.br.pizzaria.application.usecase.pedido.CriarPedidoUseCase;
import com.br.pizzaria.application.usecase.pedido.AtualizarStatusPedidoUseCase;
import com.br.pizzaria.domain.repository.PedidoRepository;
import org.springframework.stereotype.Service;

/**
 * Implementação dos casos de uso de Pedido.
 */
@Service
public class PedidoService implements CriarPedidoUseCase, AtualizarStatusPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public com.br.pizzaria.application.dto.response.PedidoResponse executar(
            com.br.pizzaria.application.dto.request.CriarPedidoRequest request) {
        // TODO: implementar
        return null;
    }

    @Override
    public com.br.pizzaria.application.dto.response.PedidoResponse executar(
            com.br.pizzaria.application.dto.request.AtualizarStatusPedidoRequest request) {
        // TODO: implementar
        return null;
    }
}
