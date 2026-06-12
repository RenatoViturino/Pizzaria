package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.CriarPerfilRequest;
import com.br.pizzaria.application.usecase.BuscarPerfilUseCase;
import com.br.pizzaria.application.usecase.CriarPerfilUseCase;
import com.br.pizzaria.domain.entity.Perfil;
import com.br.pizzaria.domain.exception.DomainException;
import com.br.pizzaria.domain.repository.PerfilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfilService implements CriarPerfilUseCase, BuscarPerfilUseCase {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    @Transactional
    public Perfil criar(CriarPerfilRequest request) {
        if (perfilRepository.existePorTipo(request.tipoPerfil())) {
            throw new DomainException("Perfil já cadastrado: " + request.tipoPerfil());
        }
        Perfil perfil = new Perfil(request.tipoPerfil(), request.regras(), request.desconto());
        return perfilRepository.salvar(perfil);
    }

    @Override
    @Transactional(readOnly = true)
    public Perfil buscarPorTipo(String tipoPerfil) {
        return perfilRepository.buscarPorTipo(tipoPerfil)
                .orElseThrow(() -> new DomainException("Perfil não encontrado: " + tipoPerfil));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Perfil> listarTodos() {
        return perfilRepository.listarTodos();
    }
}
