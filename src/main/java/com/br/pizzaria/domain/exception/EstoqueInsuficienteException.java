package com.br.pizzaria.domain.exception;

/**
 * Exceção: estoque insuficiente para realizar operação.
 */
public class EstoqueInsuficienteException extends DomainException {

    public EstoqueInsuficienteException(String nomeProduto) {
        super("Estoque insuficiente para o produto: " + nomeProduto);
    }
}
