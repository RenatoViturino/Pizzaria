package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Entrega;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída (interface do domínio): EntregaRepository
 */
public interface EntregaRepository {
    Entrega salvar(Entrega entrega);
    Optional<Entrega> buscarPorId(Long idEntrega);
    Optional<Entrega> buscarPorPedido(Long idPedido);
    List<Entrega> listarPorFuncionario(String cpfFuncionario);
}
