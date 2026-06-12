package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.AvaliarEntregaRequest;
import com.br.pizzaria.application.dto.request.CriarEntregaRequest;
import com.br.pizzaria.application.dto.response.EntregaResponse;
import com.br.pizzaria.application.usecase.AvaliarEntregaUseCase;
import com.br.pizzaria.application.usecase.CriarEntregaUseCase;
import com.br.pizzaria.domain.entity.Entrega;
import com.br.pizzaria.domain.entity.Funcionario;
import com.br.pizzaria.domain.exception.DomainException;
import com.br.pizzaria.domain.repository.EntregaRepository;
import com.br.pizzaria.domain.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntregaService implements CriarEntregaUseCase, AvaliarEntregaUseCase {

    private final EntregaRepository entregaRepository;
    private final FuncionarioRepository funcionarioRepository;

    public EntregaService(EntregaRepository entregaRepository,
                          FuncionarioRepository funcionarioRepository) {
        this.entregaRepository = entregaRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    @Transactional
    public EntregaResponse executar(CriarEntregaRequest request) {
        Funcionario funcionario = funcionarioRepository.buscarPorCpf(request.cpfFuncionario())
                .orElseThrow(() -> new DomainException("Entregador não encontrado: " + request.cpfFuncionario()));
        Entrega entrega = new Entrega(request.cpfFuncionario(), request.idPedido());
        return toResponse(entregaRepository.salvar(entrega), funcionario.getNome());
    }

    @Override
    @Transactional
    public EntregaResponse executar(AvaliarEntregaRequest request) {
        Entrega entrega = entregaRepository.buscarPorId(request.idEntrega())
                .orElseThrow(() -> new DomainException("Entrega não encontrada: " + request.idEntrega()));
        if (request.avaliacaoCliente() != null) entrega.registrarAvaliacaoCliente(request.avaliacaoCliente());
        if (request.avaliacaoEntregador() != null) entrega.registrarAvaliacaoEntregador(request.avaliacaoEntregador());
        Funcionario funcionario = funcionarioRepository.buscarPorCpf(entrega.getCpfFuncionario())
                .orElseThrow(() -> new DomainException("Entregador não encontrado."));
        return toResponse(entregaRepository.salvar(entrega), funcionario.getNome());
    }

    private EntregaResponse toResponse(Entrega e, String nomeFuncionario) {
        return new EntregaResponse(
                e.getIdEntrega(), e.getStatusEntrega().name(),
                e.getAvaliacaoCliente(), e.getAvaliacaoEntregador(),
                e.getCpfFuncionario(), nomeFuncionario, e.getIdPedido()
        );
    }
}
