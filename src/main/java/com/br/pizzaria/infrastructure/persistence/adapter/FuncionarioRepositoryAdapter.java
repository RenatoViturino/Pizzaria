package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Funcionario;
import com.br.pizzaria.domain.repository.FuncionarioRepository;
import com.br.pizzaria.infrastructure.persistence.entity.FuncionarioJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.FuncionarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FuncionarioRepositoryAdapter implements FuncionarioRepository {

    private final FuncionarioJpaRepository jpaRepository;

    public FuncionarioRepositoryAdapter(FuncionarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return toDomain(jpaRepository.save(toJpa(funcionario)));
    }

    @Override
    public Optional<Funcionario> buscarPorCpf(String cpfFuncionario) {
        return jpaRepository.findById(cpfFuncionario).map(this::toDomain);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public List<Funcionario> listarPorCargo(String cargo) {
        return jpaRepository.findByCargo(cargo).stream().map(this::toDomain).toList();
    }

    @Override
    public void deletar(String cpfFuncionario) {
        jpaRepository.deleteById(cpfFuncionario);
    }

    @Override
    public boolean existePorCpf(String cpfFuncionario) {
        return jpaRepository.existsById(cpfFuncionario);
    }

    private FuncionarioJpaEntity toJpa(Funcionario f) {
        FuncionarioJpaEntity e = new FuncionarioJpaEntity();
        e.setCpfFuncionario(f.getCpfFuncionario());
        e.setNome(f.getNome());
        e.setCargo(f.getCargo());
        e.setSalario(f.getSalario());
        e.setDataContratacao(f.getDataContratacao());
        return e;
    }

    private Funcionario toDomain(FuncionarioJpaEntity e) {
        return new Funcionario(e.getCpfFuncionario(), e.getNome(), e.getCargo(),
                e.getSalario(), e.getDataContratacao());
    }
}
