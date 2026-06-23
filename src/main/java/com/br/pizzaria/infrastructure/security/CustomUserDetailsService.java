package com.br.pizzaria.infrastructure.security;

import com.br.pizzaria.infrastructure.persistence.repository.UsuarioJpaRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Implementação de UserDetailsService necessária para o JwtAuthFilter.
 * Carrega o usuário pelo campo 'login' na tabela 'usuarios'.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioJpaRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioJpaRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login)
                .map(u -> {
                    List<SimpleGrantedAuthority> authorities = Arrays.stream(
                            u.getRoles().split(","))
                            .map(String::trim)
                            .map(SimpleGrantedAuthority::new)
                            .toList();
                    return (UserDetails) new User(u.getLogin(), u.getSenha(), authorities);
                })
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
    }
}
