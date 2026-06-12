package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.PedidoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Spring Data JPA Repository para Pedido.
 */
public interface PedidoJpaRepository extends JpaRepository<PedidoJpaEntity, UUID> {
}
