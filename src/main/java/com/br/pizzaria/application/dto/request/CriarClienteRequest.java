package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO de entrada: criar Cliente
 * CPF é informado pelo usuário (PK natural)
 */
public record CriarClienteRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfCliente,
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotBlank @Email String email,
        @NotBlank String endereco,
        @NotBlank String senha
) {}
