package com.br.pizzaria.domain.exception;

/**
 * Exceção: Cliente não encontrado pelo CPF.
 */
public class ClienteNaoEncontradoException extends DomainException {

    public ClienteNaoEncontradoException(String cpf) {
        super("Cliente não encontrado com CPF: " + cpf);
    }
}
