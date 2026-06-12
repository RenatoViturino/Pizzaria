package com.br.pizzaria.infrastructure.persistence.repository;

import com.br.pizzaria.infrastructure.persistence.entity.FuncionarioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioJpaRepository extends JpaRepository<FuncionarioJpaEntity, String> {
    List<FuncionarioJpaEntity> findByCargo(String cargo);
}
