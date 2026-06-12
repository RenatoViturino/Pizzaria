package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.CriarClienteRequest;
import com.br.pizzaria.application.dto.response.ClienteResponse;
import com.br.pizzaria.application.usecase.cliente.CriarClienteUseCase;
import com.br.pizzaria.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

/**
 * Implementação dos casos de uso de Cliente.
 * Orquestra domínio sem depender de infraestrutura diretamente.
 */
@Service
public class ClienteService implements CriarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponse executar(CriarClienteRequest request) {
        // TODO: implementar
        return null;
    }
}
