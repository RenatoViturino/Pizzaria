package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída (interface do domínio): ClienteRepository
 * A implementação fica na camada infrastructure.
 */
public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorCpf(String cpfCliente);
    Optional<Cliente> buscarPorEmail(String email);
    List<Cliente> listarTodos();
    void deletar(String cpfCliente);
    boolean existePorCpf(String cpfCliente);
}
