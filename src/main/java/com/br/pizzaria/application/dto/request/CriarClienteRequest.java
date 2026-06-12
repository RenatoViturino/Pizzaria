package com.br.pizzaria.application.dto.request;

/**
 * DTO de entrada: Criar Cliente.
 */
public record CriarClienteRequest(
    String nome,
    String email,
    String telefone,
    String senha
) {}
