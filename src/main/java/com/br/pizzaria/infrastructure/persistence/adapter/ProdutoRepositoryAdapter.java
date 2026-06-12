package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Produto;
import com.br.pizzaria.domain.repository.ProdutoRepository;
import com.br.pizzaria.infrastructure.persistence.entity.ProdutoJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.ProdutoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepository {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Produto salvar(Produto produto) {
        return toDomain(jpaRepository.save(toJpa(produto)));
    }

    @Override
    public Optional<Produto> buscarPorId(Long idProduto) {
        return jpaRepository.findById(idProduto).map(this::toDomain);
    }

    @Override
    public List<Produto> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public List<Produto> listarPorTipo(String tipo) {
        return jpaRepository.findByTipo(tipo).stream().map(this::toDomain).toList();
    }

    @Override
    public void deletar(Long idProduto) {
        jpaRepository.deleteById(idProduto);
    }

    @Override
    public boolean existePorId(Long idProduto) {
        return jpaRepository.existsById(idProduto);
    }

    private ProdutoJpaEntity toJpa(Produto p) {
        ProdutoJpaEntity e = new ProdutoJpaEntity();
        e.setIdProduto(p.getIdProduto());
        e.setNome(p.getNome());
        e.setTipo(p.getTipo());
        e.setPreco(p.getPreco());
        e.setEstoqueAtual(p.getEstoqueAtual());
        return e;
    }

    private Produto toDomain(ProdutoJpaEntity e) {
        Produto p = new Produto(e.getNome(), e.getTipo(), e.getPreco(), e.getEstoqueAtual());
        p.setIdProduto(e.getIdProduto());
        return p;
    }
}
