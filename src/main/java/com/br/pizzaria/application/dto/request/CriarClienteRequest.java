package com.br.pizzaria.application.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO de entrada: criar Cliente
 * Endereço agora usa EnderecoRequest dedicado
 */
public record CriarClienteRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfCliente,
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotNull @Valid EnderecoRequest endereco
) {}
