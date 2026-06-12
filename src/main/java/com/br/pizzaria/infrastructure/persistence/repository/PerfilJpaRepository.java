package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.PerfilJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilJpaRepository extends JpaRepository<PerfilJpaEntity, String> {
}
