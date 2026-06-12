package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.Email;

/**
 * DTO de entrada: atualizar dados do Cliente (campos opcionais)
 */
public record AtualizarClienteRequest(
        String nome,
        String telefone,
        @Email String email,
        EnderecoRequest endereco
) {}
