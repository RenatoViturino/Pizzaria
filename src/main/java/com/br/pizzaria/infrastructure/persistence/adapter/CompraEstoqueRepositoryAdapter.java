package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.CompraEstoque;
import com.br.pizzaria.domain.repository.CompraEstoqueRepository;
import com.br.pizzaria.infrastructure.persistence.entity.CompraEstoqueJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.CompraEstoqueJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CompraEstoqueRepositoryAdapter implements CompraEstoqueRepository {

    private final CompraEstoqueJpaRepository jpaRepository;

    public CompraEstoqueRepositoryAdapter(CompraEstoqueJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CompraEstoque salvar(CompraEstoque compra) {
        return toDomain(jpaRepository.save(toJpa(compra)));
    }

    @Override
    public Optional<CompraEstoque> buscarPorId(Long idCompra) {
        return jpaRepository.findById(idCompra).map(this::toDomain);
    }

    @Override
    public List<CompraEstoque> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public List<CompraEstoque> listarPorFornecedor(String fornecedor) {
        return jpaRepository.findByFornecedor(fornecedor).stream().map(this::toDomain).toList();
    }

    @Override
    public List<CompraEstoque> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return jpaRepository.findByDataCompraBetween(inicio, fim).stream().map(this::toDomain).toList();
    }

    @Override
    public void deletar(Long idCompra) {
        jpaRepository.deleteById(idCompra);
    }

    private CompraEstoqueJpaEntity toJpa(CompraEstoque c) {
        CompraEstoqueJpaEntity e = new CompraEstoqueJpaEntity();
        e.setIdCompra(c.getIdCompra());
        e.setFornecedor(c.getFornecedor());
        e.setDataCompra(c.getDataCompra());
        e.setValorTotal(c.getValorTotal());
        return e;
    }

    private CompraEstoque toDomain(CompraEstoqueJpaEntity e) {
        CompraEstoque c = new CompraEstoque(e.getFornecedor(), e.getDataCompra(), e.getValorTotal());
        c.setIdCompra(e.getIdCompra());
        return c;
    }
}
