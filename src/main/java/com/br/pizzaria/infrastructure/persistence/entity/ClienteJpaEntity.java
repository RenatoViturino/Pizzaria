package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;

/**
 * Entidade JPA de Cliente — mapeamento para o PostgreSQL.
 * Separada da entidade de domínio (Clean Architecture).
 */
@Entity
@Table(name = "clientes")
public class ClienteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String telefone;

    @Column(nullable = false)
    private String senha;

    // TODO: getters, setters via Lombok ou manual
}
