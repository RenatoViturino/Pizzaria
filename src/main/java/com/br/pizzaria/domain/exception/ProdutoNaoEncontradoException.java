package com.br.pizzaria.domain.exception;

/**
 * Exceção: Produto não encontrado pelo ID.
 */
public class ProdutoNaoEncontradoException extends DomainException {

    public ProdutoNaoEncontradoException(Long idProduto) {
        super("Produto não encontrado com id: " + idProduto);
    }
}
