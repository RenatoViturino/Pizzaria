package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.PedidoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoJpaRepository extends JpaRepository<PedidoJpaEntity, Long> {
    List<PedidoJpaEntity> findByClienteCpfCliente(String cpfCliente);
}
