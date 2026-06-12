package com.br.pizzaria.domain.exception;

/**
 * Exceção base do domínio.
 * Não carrega dependências de framework — pura Java.
 */
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
