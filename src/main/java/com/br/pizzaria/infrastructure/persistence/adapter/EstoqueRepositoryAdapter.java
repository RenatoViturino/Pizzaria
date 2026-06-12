package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Estoque;
import com.br.pizzaria.domain.repository.EstoqueRepository;
import com.br.pizzaria.infrastructure.persistence.entity.EstoqueJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.EstoqueJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstoqueRepositoryAdapter implements EstoqueRepository {

    private final EstoqueJpaRepository jpaRepository;

    public EstoqueRepositoryAdapter(EstoqueJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Estoque salvar(Estoque estoque) {
        return toDomain(jpaRepository.save(toJpa(estoque)));
    }

    @Override
    public Optional<Estoque> buscarPorId(Long idMovimento) {
        return jpaRepository.findById(idMovimento).map(this::toDomain);
    }

    @Override
    public List<Estoque> listarPorProduto(Long idProduto) {
        return jpaRepository.findByIdProduto(idProduto).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Estoque> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public List<Estoque> listarPorTipoMovimento(String tipoMovimento) {
        return jpaRepository.findByTipoMovimento(tipoMovimento).stream().map(this::toDomain).toList();
    }

    private EstoqueJpaEntity toJpa(Estoque e) {
        EstoqueJpaEntity je = new EstoqueJpaEntity();
        je.setIdMovimento(e.getIdMovimento());
        je.setTipoMovimento(e.getTipoMovimento());
        je.setQuantidade(e.getQuantidade());
        je.setDataHora(e.getDataHora());
        je.setIdProduto(e.getIdProduto());
        return je;
    }

    private Estoque toDomain(EstoqueJpaEntity je) {
        Estoque e = new Estoque(je.getTipoMovimento(), je.getQuantidade(), je.getIdProduto());
        e.setIdMovimento(je.getIdMovimento());
        e.setDataHora(je.getDataHora());
        return e;
    }
}
