package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.EstoqueJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueJpaRepository extends JpaRepository<EstoqueJpaEntity, Long> {
    List<EstoqueJpaEntity> findByIdProduto(Long idProduto);
    List<EstoqueJpaEntity> findByTipoMovimento(String tipoMovimento);
}
