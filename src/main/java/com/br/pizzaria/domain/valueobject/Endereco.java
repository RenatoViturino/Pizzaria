package com.br.pizzaria.domain.valueobject;

/**
 * Value Object: Endereco
 * Imutável por definição (record)
 */
public record Endereco(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
    public Endereco {
        if (logradouro == null || logradouro.isBlank()) throw new IllegalArgumentException("Logradouro obrigatório.");
        if (cep == null || cep.isBlank()) throw new IllegalArgumentException("CEP obrigatório.");
    }

    public String formatado() {
        return logradouro + ", " + numero +
               (complemento != null && !complemento.isBlank() ? " - " + complemento : "") +
               ", " + bairro + ", " + cidade + "/" + estado + " - " + cep;
    }
}
