package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.response.PedidoResponse;

import java.util.List;

public interface BuscarPedidoUseCase {
    PedidoResponse buscarPorId(Long idPedido);
    List<PedidoResponse> listarPorCliente(String cpfCliente);
    List<PedidoResponse> listarTodos();
}
