package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Pedido;
import com.br.pizzaria.domain.valueobject.StatusPedido;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída (interface do domínio): PedidoRepository
 */
public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long idPedido);
    List<Pedido> listarPorCliente(String cpfCliente);
    List<Pedido> listarPorStatus(StatusPedido status);
    List<Pedido> listarTodos();
}
