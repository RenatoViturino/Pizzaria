package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.EntregaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntregaJpaRepository extends JpaRepository<EntregaJpaEntity, Long> {
    Optional<EntregaJpaEntity> findByIdPedido(Long idPedido);
    List<EntregaJpaEntity> findByCpfFuncionario(String cpfFuncionario);
}
