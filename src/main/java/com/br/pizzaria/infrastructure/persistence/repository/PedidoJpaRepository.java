package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import com.br.pizzaria.infrastructure.persistence.entity.PedidoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoJpaRepository extends JpaRepository<PedidoJpaEntity, Long> {
    List<PedidoJpaEntity> findByCpfCliente(String cpfCliente);
    List<PedidoJpaEntity> findByStatus(StatusPedido status);
}
