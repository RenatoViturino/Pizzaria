package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.PagamentoFuncionario;
import com.br.pizzaria.domain.repository.PagamentoFuncionarioRepository;
import com.br.pizzaria.infrastructure.persistence.entity.PagamentoFuncionarioJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.PagamentoFuncionarioJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class PagamentoFuncionarioRepositoryAdapter implements PagamentoFuncionarioRepository {

    private final PagamentoFuncionarioJpaRepository jpaRepository;

    public PagamentoFuncionarioRepositoryAdapter(PagamentoFuncionarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PagamentoFuncionario salvar(PagamentoFuncionario pagamento) {
        return toDomain(jpaRepository.save(toJpa(pagamento)));
    }

    @Override
    public Optional<PagamentoFuncionario> buscarPorId(Long idPagamento) {
        return jpaRepository.findById(idPagamento).map(this::toDomain);
    }

    @Override
    public List<PagamentoFuncionario> listarPorFuncionario(String cpfFuncionario) {
        return jpaRepository.findByCpfFuncionario(cpfFuncionario).stream().map(this::toDomain).toList();
    }

    @Override
    public List<PagamentoFuncionario> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return jpaRepository.findByDataPagamentoBetween(inicio, fim).stream().map(this::toDomain).toList();
    }

    @Override
    public List<PagamentoFuncionario> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    private PagamentoFuncionarioJpaEntity toJpa(PagamentoFuncionario p) {
        PagamentoFuncionarioJpaEntity e = new PagamentoFuncionarioJpaEntity();
        e.setIdPagamento(p.getIdPagamento());
        e.setValor(p.getValor());
        e.setDataPagamento(p.getDataPagamento());
        e.setCpfFuncionario(p.getCpfFuncionario());
        return e;
    }

    private PagamentoFuncionario toDomain(PagamentoFuncionarioJpaEntity e) {
        PagamentoFuncionario p = new PagamentoFuncionario(e.getValor(), e.getDataPagamento(), e.getCpfFuncionario());
        p.setIdPagamento(e.getIdPagamento());
        return p;
    }
}
