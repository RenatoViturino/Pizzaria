package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.ClienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteJpaRepository extends JpaRepository<ClienteJpaEntity, String> {
    Optional<ClienteJpaEntity> findByEmail(String email);
}
