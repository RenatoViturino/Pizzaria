package com.br.pizzaria.domain.exception;

/**
 * Exceção base do domínio.
 */
public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
