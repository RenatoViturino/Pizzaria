package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.CriarCompraEstoqueRequest;
import com.br.pizzaria.application.usecase.BuscarCompraEstoqueUseCase;
import com.br.pizzaria.application.usecase.CriarCompraEstoqueUseCase;
import com.br.pizzaria.domain.entity.CompraEstoque;
import com.br.pizzaria.domain.exception.DomainException;
import com.br.pizzaria.domain.repository.CompraEstoqueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraEstoqueService implements CriarCompraEstoqueUseCase, BuscarCompraEstoqueUseCase {

    private final CompraEstoqueRepository compraEstoqueRepository;

    public CompraEstoqueService(CompraEstoqueRepository compraEstoqueRepository) {
        this.compraEstoqueRepository = compraEstoqueRepository;
    }

    @Override
    @Transactional
    public CompraEstoque criar(CriarCompraEstoqueRequest request) {
        CompraEstoque compra = new CompraEstoque(
                request.fornecedor(),
                request.dataCompra(),
                request.valorTotal()
        );
        return compraEstoqueRepository.salvar(compra);
    }

    @Override
    @Transactional(readOnly = true)
    public CompraEstoque buscarPorId(Long idCompra) {
        return compraEstoqueRepository.buscarPorId(idCompra)
                .orElseThrow(() -> new DomainException("Compra não encontrada: " + idCompra));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraEstoque> listarTodos() {
        return compraEstoqueRepository.listarTodos();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraEstoque> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return compraEstoqueRepository.listarPorPeriodo(inicio, fim);
    }
}
