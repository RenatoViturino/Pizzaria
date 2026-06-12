package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.AtualizarClienteRequest;
import com.br.pizzaria.application.dto.response.ClienteResponse;

public interface AtualizarClienteUseCase {
    ClienteResponse executar(String cpfCliente, AtualizarClienteRequest request);
}
