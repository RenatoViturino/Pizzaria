package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Pedido;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Porta de saída: repositório de Pedidos.
 */
public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(UUID id);
    List<Pedido> listarTodos();
}
