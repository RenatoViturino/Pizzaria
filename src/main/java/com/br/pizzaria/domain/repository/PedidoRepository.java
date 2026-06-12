package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Pedido;
import java.util.List;
import java.util.Optional;

/**
 * Porta de saída: repositório de Pedido (PK: Long idPedido)
 */
public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long id);
    List<Pedido> listarPorCliente(String cpfCliente);
    List<Pedido> listarTodos();
}
