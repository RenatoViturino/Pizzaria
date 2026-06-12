package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Funcionario;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída (interface do domínio): FuncionarioRepository
 */
public interface FuncionarioRepository {
    Funcionario salvar(Funcionario funcionario);
    Optional<Funcionario> buscarPorCpf(String cpfFuncionario);
    List<Funcionario> listarTodos();
    List<Funcionario> listarPorCargo(String cargo);
    void deletar(String cpfFuncionario);
    boolean existePorCpf(String cpfFuncionario);
}
