package com.br.pizzaria.application.dto.response;

import java.util.UUID;

/**
 * DTO de saída: Cliente.
 */
public record ClienteResponse(
    UUID id,
    String nome,
    String email,
    String telefone
) {}
