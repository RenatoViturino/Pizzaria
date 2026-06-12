package com.br.pizzaria.application.usecase.pizza;

import com.br.pizzaria.application.dto.request.CriarPizzaRequest;
import com.br.pizzaria.application.dto.response.PizzaResponse;

/**
 * Caso de uso: Criar Pizza (cardápio).
 */
public interface CriarPizzaUseCase {
    PizzaResponse executar(CriarPizzaRequest request);
}
