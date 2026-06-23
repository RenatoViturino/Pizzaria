package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidade de autenticação.
 * Armazena login, senha (BCrypt) e roles do usuário.
 * Usada pelo CustomUserDetailsService para carregar o principal JWT.
 */
@Entity
@Table(name = "usuarios")
public class UsuarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "login", nullable = false, unique = true, length = 100)
    private String login;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    /** Roles separadas por vírgula, ex: "ROLE_ADMIN,ROLE_FUNCIONARIO" */
    @Column(name = "roles", nullable = false, length = 255)
    private String roles;

    public UsuarioJpaEntity() {}

    public UsuarioJpaEntity(String login, String senha, String roles) {
        this.login = login;
        this.senha = senha;
        this.roles = roles;
    }

    public Long getIdUsuario()              { return idUsuario; }
    public void setIdUsuario(Long v)        { this.idUsuario = v; }
    public String getLogin()                { return login; }
    public void setLogin(String v)          { this.login = v; }
    public String getSenha()                { return senha; }
    public void setSenha(String v)          { this.senha = v; }
    public String getRoles()                { return roles; }
    public void setRoles(String v)          { this.roles = v; }
}
