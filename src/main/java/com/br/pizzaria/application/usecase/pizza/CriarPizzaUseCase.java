package com.br.pizzaria.application.usecase.pizza;

import com.br.pizzaria.application.dto.response.ProdutoResponse;
import com.br.pizzaria.domain.entity.Produto;

/**
 * Caso de uso: Criar Pizza (cardápio).
 */
public interface CriarPizzaUseCase {
    ProdutoResponse executar(Produto request);
}
