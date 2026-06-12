package com.br.pizzaria.application.usecase.pizza;

/**
 * Caso de uso: Criar Pizza (cardápio).
 */
public interface CriarPizzaUseCase {
    PizzaResponse executar(CriarPizzaRequest request);
}
