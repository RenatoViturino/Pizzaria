package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.PagamentoFuncionario;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagamentoFuncionarioRepository {
    PagamentoFuncionario salvar(PagamentoFuncionario pagamento);
    Optional<PagamentoFuncionario> buscarPorId(Long idPagamento);
    List<PagamentoFuncionario> listarPorFuncionario(String cpfFuncionario);
    List<PagamentoFuncionario> listarPorPeriodo(LocalDate inicio, LocalDate fim);
    List<PagamentoFuncionario> listarTodos();
}
