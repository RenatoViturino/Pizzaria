package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Perfil;

import java.util.List;
import java.util.Optional;

public interface PerfilRepository {
    Perfil salvar(Perfil perfil);
    Optional<Perfil> buscarPorTipo(String tipoPerfil);
    List<Perfil> listarTodos();
    void deletar(String tipoPerfil);
    boolean existePorTipo(String tipoPerfil);
}
