package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarEntregaRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfFuncionario,
        @NotNull Long idPedido
) {}
