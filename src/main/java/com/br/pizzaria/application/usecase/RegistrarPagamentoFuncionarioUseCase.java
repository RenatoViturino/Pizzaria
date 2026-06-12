package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarPagamentoFuncionarioRequest;
import com.br.pizzaria.application.dto.response.PagamentoFuncionarioResponse;

public interface RegistrarPagamentoFuncionarioUseCase {
    PagamentoFuncionarioResponse executar(CriarPagamentoFuncionarioRequest request);
}
