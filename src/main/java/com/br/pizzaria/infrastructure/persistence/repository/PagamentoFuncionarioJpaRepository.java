package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.PagamentoFuncionarioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PagamentoFuncionarioJpaRepository extends JpaRepository<PagamentoFuncionarioJpaEntity, Long> {
    List<PagamentoFuncionarioJpaEntity> findByCpfFuncionario(String cpfFuncionario);
    List<PagamentoFuncionarioJpaEntity> findByDataPagamentoBetween(LocalDate inicio, LocalDate fim);
}
