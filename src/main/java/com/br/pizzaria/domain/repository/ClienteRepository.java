package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Cliente;
import java.util.Optional;
import java.util.UUID;

/**
 * Porta de saída (interface de repositório) — definida no domínio.
 * A implementação fica na camada de infraestrutura.
 */
public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorId(UUID id);
    void deletar(UUID id);
}
