package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.AvaliarEntregaRequest;
import com.br.pizzaria.application.dto.response.EntregaResponse;

public interface AvaliarEntregaUseCase {
    EntregaResponse executar(AvaliarEntregaRequest request);
}
