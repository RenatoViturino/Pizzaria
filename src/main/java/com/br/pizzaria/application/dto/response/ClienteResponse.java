package com.br.pizzaria.application.dto.response;

import java.util.List;

/**
 * DTO de resposta: Cliente
 * PK: cpfCliente (String) — conforme diagrama
 */
public record ClienteResponse(
        String cpfCliente,
        String nome,
        String telefone,
        String email,
        String endereco,
        Integer pontuacao,
        String tipoPerfil
) {}
