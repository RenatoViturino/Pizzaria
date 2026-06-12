package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarEntregaRequest;
import com.br.pizzaria.application.dto.response.EntregaResponse;

public interface CriarEntregaUseCase {
    EntregaResponse executar(CriarEntregaRequest request);
}
