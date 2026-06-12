package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Pizza;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Porta de saída: repositório de Pizzas.
 */
public interface PizzaRepository {
    Pizza salvar(Pizza pizza);
    Optional<Pizza> buscarPorId(UUID id);
    List<Pizza> listarTodas();
    void deletar(UUID id);
}
