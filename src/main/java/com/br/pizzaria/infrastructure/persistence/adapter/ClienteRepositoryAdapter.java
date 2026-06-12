package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Cliente;
import com.br.pizzaria.domain.repository.ClienteRepository;
import com.br.pizzaria.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * Adaptador: implementa a interface de repositório do domínio
 * usando o Spring Data JPA. Padrão Adapter da Clean Architecture.
 */
@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        // TODO: mapear domínio → JPA → salvar → mapear JPA → domínio
        return null;
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        // TODO: implementar
        return Optional.empty();
    }

    @Override
    public void deletar(UUID id) {
        jpaRepository.deleteById(id);
    }
}
