package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.MovimentarEstoqueRequest;
import com.br.pizzaria.application.dto.response.EstoqueResponse;

public interface MovimentarEstoqueUseCase {
    EstoqueResponse executar(MovimentarEstoqueRequest request);
}
