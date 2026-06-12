package com.br.pizzaria.application.dto.response;

/**
 * DTO de resposta: Endereço (embutido em ClienteResponse)
 */
public record EnderecoResponse(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}
