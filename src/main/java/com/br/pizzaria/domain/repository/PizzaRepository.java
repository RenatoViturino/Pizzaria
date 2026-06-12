package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Produto;
import java.util.List;
import java.util.Optional;

public interface PizzaRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Long id);
    List<Produto> listarTodos();
    void deletar(Long id);
}
