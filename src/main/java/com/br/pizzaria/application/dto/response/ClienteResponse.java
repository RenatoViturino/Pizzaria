package com.br.pizzaria.application.dto.response;

/**
 * DTO de resposta: Cliente
 * PK: cpfCliente (String)
 */
public record ClienteResponse(
        String cpfCliente,
        String nome,
        String telefone,
        String email,
        EnderecoResponse endereco,
        Integer pontuacao,
        String tipoPerfil
) {}
