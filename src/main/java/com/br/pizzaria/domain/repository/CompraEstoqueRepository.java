package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.CompraEstoque;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CompraEstoqueRepository {
    CompraEstoque salvar(CompraEstoque compra);
    Optional<CompraEstoque> buscarPorId(Long idCompra);
    List<CompraEstoque> listarTodos();
    List<CompraEstoque> listarPorFornecedor(String fornecedor);
    List<CompraEstoque> listarPorPeriodo(LocalDate inicio, LocalDate fim);
    void deletar(Long idCompra);
}
