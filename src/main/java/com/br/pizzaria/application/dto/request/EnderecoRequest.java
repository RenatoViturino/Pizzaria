package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO de entrada: Endereço (usado em CriarClienteRequest e AtualizarClienteRequest)
 */
public record EnderecoRequest(
        @NotBlank String logradouro,
        @NotBlank String numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String estado,
        @NotBlank String cep
) {}
