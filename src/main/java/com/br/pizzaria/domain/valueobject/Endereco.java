package com.br.pizzaria.domain.valueobject;

/**
 * Value Object: Endereço
 * Imutável — sem identidade própria.
 */
public record Endereco(
    String logradouro,
    String numero,
    String bairro,
    String cidade,
    String cep
) {}
