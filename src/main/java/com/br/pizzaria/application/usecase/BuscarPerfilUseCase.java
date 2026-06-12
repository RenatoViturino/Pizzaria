package com.br.pizzaria.application.usecase;

import com.br.pizzaria.domain.entity.Perfil;

import java.util.List;

public interface BuscarPerfilUseCase {
    Perfil buscarPorTipo(String tipoPerfil);
    List<Perfil> listarTodos();
}
