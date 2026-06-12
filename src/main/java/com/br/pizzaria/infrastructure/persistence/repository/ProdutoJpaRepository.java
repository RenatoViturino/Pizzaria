package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.ProdutoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Spring Data JPA Repository para Produto (PK: Long idProduto)
 */
public interface ProdutoJpaRepository extends JpaRepository<ProdutoJpaEntity, Long> {
    List<ProdutoJpaEntity> findByTipo(String tipo);
}
