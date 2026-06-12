package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarPerfilRequest;
import com.br.pizzaria.domain.entity.Perfil;

public interface CriarPerfilUseCase {
    Perfil criar(CriarPerfilRequest request);
}
