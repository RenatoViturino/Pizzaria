package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.response.ClienteResponse;

import java.util.List;

public interface BuscarClienteUseCase {
    ClienteResponse buscarPorCpf(String cpfCliente);
    List<ClienteResponse> listarTodos();
}
