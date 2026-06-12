package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * DTO de entrada: enviar SMS
 */
public record EnviarSmsRequest(
        @NotBlank @Pattern(regexp = "\\d{10,11}", message = "Número deve ter 10 ou 11 dígitos") String numero,
        @NotBlank String mensagem
) {}
