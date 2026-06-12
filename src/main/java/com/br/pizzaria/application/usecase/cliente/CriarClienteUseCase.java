package com.br.pizzaria.application.usecase.cliente;

import com.br.pizzaria.application.dto.request.CriarClienteRequest;
import com.br.pizzaria.application.dto.response.ClienteResponse;

/**
 * Caso de uso: Criar Cliente.
 * Porta de entrada (interface) — implementada no próprio pacote.
 */
public interface CriarClienteUseCase {
    ClienteResponse executar(CriarClienteRequest request);
}
