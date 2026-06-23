package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.AtualizarClienteRequest;
import com.br.pizzaria.application.dto.request.CriarClienteRequest;
import com.br.pizzaria.application.dto.request.EnderecoRequest;
import com.br.pizzaria.application.dto.response.ClienteResponse;
import com.br.pizzaria.application.dto.response.EnderecoResponse;
import com.br.pizzaria.application.usecase.AtualizarClienteUseCase;
import com.br.pizzaria.application.usecase.BuscarClienteUseCase;
import com.br.pizzaria.application.usecase.cliente.CriarClienteUseCase; // FIX: pacote correto
import com.br.pizzaria.domain.entity.Cliente;
import com.br.pizzaria.domain.exception.ClienteNaoEncontradoException;
import com.br.pizzaria.domain.exception.DomainException;
import com.br.pizzaria.domain.repository.ClienteRepository;
import com.br.pizzaria.domain.valueobject.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service de cliente.
 * Implementa os use cases de criar, buscar e atualizar clientes.
 * A injeção de dependência via construtor segue o princípio de
 * Inversão de Dependência (DIP): depende de abstrações (interfaces),
 * não de implementações concretas.
 */
@Service
public class ClienteService implements CriarClienteUseCase, BuscarClienteUseCase, AtualizarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public ClienteResponse executar(CriarClienteRequest request) {
        if (clienteRepository.existePorCpf(request.cpfCliente())) {
            throw new DomainException("CPF já cadastrado: " + request.cpfCliente());
        }
        Endereco endereco = toEndereco(request.endereco());
        Cliente cliente = new Cliente(
                request.cpfCliente(), request.nome(), request.telefone(),
                request.email(), request.senha(), endereco
        );
        return toResponse(clienteRepository.salvar(cliente));
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse buscarPorCpf(String cpfCliente) {
        return clienteRepository.buscarPorCpf(cpfCliente)
                .map(this::toResponse)
                .orElseThrow(() -> new ClienteNaoEncontradoException(cpfCliente));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponse> listarTodos() {
        return clienteRepository.listarTodos().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public ClienteResponse executar(String cpfCliente, AtualizarClienteRequest request) {
        Cliente cliente = clienteRepository.buscarPorCpf(cpfCliente)
                .orElseThrow(() -> new ClienteNaoEncontradoException(cpfCliente));
        if (request.nome() != null) cliente.setNome(request.nome());
        if (request.telefone() != null) cliente.setTelefone(request.telefone());
        if (request.email() != null) cliente.setEmail(request.email());
        if (request.endereco() != null) cliente.setEndereco(toEndereco(request.endereco()));
        return toResponse(clienteRepository.salvar(cliente));
    }

    // ---- mappers internos ----

    private Endereco toEndereco(EnderecoRequest r) {
        return new Endereco(r.logradouro(), r.numero(), r.complemento(),
                r.bairro(), r.cidade(), r.estado(), r.cep());
    }

    private ClienteResponse toResponse(Cliente c) {
        EnderecoResponse end = c.getEndereco() == null ? null : new EnderecoResponse(
                c.getEndereco().logradouro(), c.getEndereco().numero(),
                c.getEndereco().complemento(), c.getEndereco().bairro(),
                c.getEndereco().cidade(), c.getEndereco().estado(), c.getEndereco().cep()
        );
        return new ClienteResponse(
                c.getCpfCliente(), c.getNome(), c.getTelefone(), c.getEmail(),
                end, c.getPontuacao(), c.getTipoPerfil().name()
        );
    }
}
