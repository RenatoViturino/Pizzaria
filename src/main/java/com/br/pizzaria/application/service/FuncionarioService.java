package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.AtualizarFuncionarioRequest;
import com.br.pizzaria.application.dto.request.CriarFuncionarioRequest;
import com.br.pizzaria.application.dto.response.FuncionarioResponse;
import com.br.pizzaria.application.usecase.AtualizarClienteUseCase;
import com.br.pizzaria.application.usecase.BuscarFuncionarioUseCase;
import com.br.pizzaria.application.usecase.CriarFuncionarioUseCase;
import com.br.pizzaria.domain.entity.Funcionario;
import com.br.pizzaria.domain.exception.DomainException;
import com.br.pizzaria.domain.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService implements CriarFuncionarioUseCase, BuscarFuncionarioUseCase {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    @Transactional
    public FuncionarioResponse executar(CriarFuncionarioRequest request) {
        if (funcionarioRepository.existePorCpf(request.cpfFuncionario())) {
            throw new DomainException("CPF de funcionário já cadastrado: " + request.cpfFuncionario());
        }
        Funcionario funcionario = new Funcionario(
                request.cpfFuncionario(), request.nome(), request.cargo(),
                request.salario(), request.dataContratacao()
        );
        return toResponse(funcionarioRepository.salvar(funcionario));
    }

    @Override
    @Transactional(readOnly = true)
    public FuncionarioResponse buscarPorCpf(String cpfFuncionario) {
        return funcionarioRepository.buscarPorCpf(cpfFuncionario)
                .map(this::toResponse)
                .orElseThrow(() -> new DomainException("Funcionário não encontrado: " + cpfFuncionario));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FuncionarioResponse> listarTodos() {
        return funcionarioRepository.listarTodos().stream().map(this::toResponse).toList();
    }

    @Transactional
    public FuncionarioResponse atualizar(String cpfFuncionario, AtualizarFuncionarioRequest request) {
        Funcionario f = funcionarioRepository.buscarPorCpf(cpfFuncionario)
                .orElseThrow(() -> new DomainException("Funcionário não encontrado: " + cpfFuncionario));
        if (request.nome() != null) f.setNome(request.nome());
        if (request.cargo() != null) f.setCargo(request.cargo());
        if (request.salario() != null) f.setSalario(request.salario());
        return toResponse(funcionarioRepository.salvar(f));
    }

    private FuncionarioResponse toResponse(Funcionario f) {
        return new FuncionarioResponse(
                f.getCpfFuncionario(), f.getNome(), f.getCargo(),
                f.getSalario(), f.getDataContratacao()
        );
    }
}
