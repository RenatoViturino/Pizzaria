package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarFuncionarioRequest;
import com.br.pizzaria.application.dto.response.FuncionarioResponse;

public interface CriarFuncionarioUseCase {
    FuncionarioResponse executar(CriarFuncionarioRequest request);
}
