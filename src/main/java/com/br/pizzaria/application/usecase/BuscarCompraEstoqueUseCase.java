package com.br.pizzaria.application.usecase;

import com.br.pizzaria.domain.entity.CompraEstoque;

import java.time.LocalDate;
import java.util.List;

public interface BuscarCompraEstoqueUseCase {
    CompraEstoque buscarPorId(Long idCompra);
    List<CompraEstoque> listarTodos();
    List<CompraEstoque> listarPorPeriodo(LocalDate inicio, LocalDate fim);
}
