package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Perfil;
import com.br.pizzaria.domain.repository.PerfilRepository;
import com.br.pizzaria.infrastructure.persistence.entity.PerfilJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.PerfilJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PerfilRepositoryAdapter implements PerfilRepository {

    private final PerfilJpaRepository jpaRepository;

    public PerfilRepositoryAdapter(PerfilJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Perfil salvar(Perfil perfil) {
        return toDomain(jpaRepository.save(toJpa(perfil)));
    }

    @Override
    public Optional<Perfil> buscarPorTipo(String tipoPerfil) {
        return jpaRepository.findById(tipoPerfil).map(this::toDomain);
    }

    @Override
    public List<Perfil> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deletar(String tipoPerfil) {
        jpaRepository.deleteById(tipoPerfil);
    }

    @Override
    public boolean existePorTipo(String tipoPerfil) {
        return jpaRepository.existsById(tipoPerfil);
    }

    private PerfilJpaEntity toJpa(Perfil p) {
        PerfilJpaEntity e = new PerfilJpaEntity();
        e.setTipoPerfil(p.getTipoPerfil());
        e.setRegras(p.getRegras());
        e.setDesconto(p.getDesconto());
        return e;
    }

    private Perfil toDomain(PerfilJpaEntity e) {
        return new Perfil(e.getTipoPerfil(), e.getRegras(), e.getDesconto());
    }
}
