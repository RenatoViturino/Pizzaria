package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarClienteRequest;
import com.br.pizzaria.application.dto.response.ClienteResponse;

public interface CriarClienteUseCase {
    ClienteResponse executar(CriarClienteRequest request);
}
