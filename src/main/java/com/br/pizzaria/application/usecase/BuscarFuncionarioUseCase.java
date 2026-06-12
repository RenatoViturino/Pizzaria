package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.response.FuncionarioResponse;

import java.util.List;

public interface BuscarFuncionarioUseCase {
    FuncionarioResponse buscarPorCpf(String cpfFuncionario);
    List<FuncionarioResponse> listarTodos();
}
