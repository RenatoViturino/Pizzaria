package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.CompraEstoqueJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompraEstoqueJpaRepository extends JpaRepository<CompraEstoqueJpaEntity, Long> {
    List<CompraEstoqueJpaEntity> findByFornecedor(String fornecedor);
    List<CompraEstoqueJpaEntity> findByDataCompraBetween(LocalDate inicio, LocalDate fim);
}
