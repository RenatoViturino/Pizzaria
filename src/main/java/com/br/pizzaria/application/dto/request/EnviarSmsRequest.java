package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnviarSmsRequest(
        @NotBlank @Size(min = 10, max = 11) String numero,
        @NotBlank @Size(max = 500) String mensagem
) {}
