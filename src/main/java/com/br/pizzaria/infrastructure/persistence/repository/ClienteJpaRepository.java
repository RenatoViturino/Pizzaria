package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.ClienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Spring Data JPA Repository para Cliente.
 */
public interface ClienteJpaRepository extends JpaRepository<ClienteJpaEntity, UUID> {
    java.util.Optional<ClienteJpaEntity> findByEmail(String email);
}
