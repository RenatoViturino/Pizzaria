package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Cliente;
import java.util.List;
import java.util.Optional;

/**
 * Porta de saída: repositório de Cliente (PK: String cpfCliente)
 */
public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorCpf(String cpf);
    Optional<Cliente> buscarPorEmail(String email);
    List<Cliente> listarTodos();
    void deletar(String cpf);
}
