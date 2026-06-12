package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarPerfilRequest(
        @NotBlank String tipoPerfil,
        @NotBlank String regras,
        @NotNull @Min(0) @Max(100) Integer desconto
) {}
