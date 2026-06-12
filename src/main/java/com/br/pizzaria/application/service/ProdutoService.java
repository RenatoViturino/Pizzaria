package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.AtualizarProdutoRequest;
import com.br.pizzaria.application.dto.request.CriarProdutoRequest;
import com.br.pizzaria.application.dto.response.ProdutoResponse;
import com.br.pizzaria.application.usecase.AtualizarProdutoUseCase;
import com.br.pizzaria.application.usecase.BuscarProdutoUseCase;
import com.br.pizzaria.application.usecase.CriarProdutoUseCase;
import com.br.pizzaria.domain.entity.Produto;
import com.br.pizzaria.domain.exception.ProdutoNaoEncontradoException;
import com.br.pizzaria.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService implements CriarProdutoUseCase, BuscarProdutoUseCase, AtualizarProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public ProdutoResponse executar(CriarProdutoRequest request) {
        Produto produto = new Produto(request.nome(), request.tipo(), request.preco(), request.estoqueAtual());
        return toResponse(produtoRepository.salvar(produto));
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoResponse buscarPorId(Long idProduto) {
        return produtoRepository.buscarPorId(idProduto)
                .map(this::toResponse)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(idProduto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponse> listarTodos() {
        return produtoRepository.listarTodos().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponse> listarPorTipo(String tipo) {
        return produtoRepository.listarPorTipo(tipo).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public ProdutoResponse executar(Long idProduto, AtualizarProdutoRequest request) {
        Produto produto = produtoRepository.buscarPorId(idProduto)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(idProduto));
        if (request.nome() != null) produto.setNome(request.nome());
        if (request.tipo() != null) produto.setTipo(request.tipo());
        if (request.preco() != null) produto.setPreco(request.preco());
        return toResponse(produtoRepository.salvar(produto));
    }

    private ProdutoResponse toResponse(Produto p) {
        return new ProdutoResponse(p.getIdProduto(), p.getNome(), p.getTipo(), p.getPreco(), p.getEstoqueAtual());
    }
}
