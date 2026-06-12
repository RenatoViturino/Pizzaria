package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Cliente;
import com.br.pizzaria.domain.repository.ClienteRepository;
import com.br.pizzaria.domain.valueobject.Endereco;
import com.br.pizzaria.domain.valueobject.TipoPerfil;
import com.br.pizzaria.infrastructure.persistence.entity.ClienteJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return toDomain(jpaRepository.save(toJpa(cliente)));
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String cpfCliente) {
        return jpaRepository.findById(cpfCliente).map(this::toDomain);
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return jpaRepository.findByEmail(email).map(this::toDomain);
    }

    @Override
    public List<Cliente> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deletar(String cpfCliente) {
        jpaRepository.deleteById(cpfCliente);
    }

    @Override
    public boolean existePorCpf(String cpfCliente) {
        return jpaRepository.existsById(cpfCliente);
    }

    // ---- mappers ----

    private ClienteJpaEntity toJpa(Cliente c) {
        ClienteJpaEntity e = new ClienteJpaEntity();
        e.setCpfCliente(c.getCpfCliente());
        e.setNome(c.getNome());
        e.setTelefone(c.getTelefone());
        e.setEmail(c.getEmail());
        e.setSenha(c.getSenha());
        e.setPontuacao(c.getPontuacao());
        e.setTipoPerfil(c.getTipoPerfil() != null ? c.getTipoPerfil().name() : TipoPerfil.BRONZE.name());
        if (c.getEndereco() != null) {
            Endereco end = c.getEndereco();
            e.setLogradouro(end.logradouro());
            e.setNumero(end.numero());
            e.setComplemento(end.complemento());
            e.setBairro(end.bairro());
            e.setCidade(end.cidade());
            e.setEstado(end.estado());
            e.setCep(end.cep());
        }
        return e;
    }

    private Cliente toDomain(ClienteJpaEntity e) {
        Endereco endereco = new Endereco(
                e.getLogradouro(), e.getNumero(), e.getComplemento(),
                e.getBairro(), e.getCidade(), e.getEstado(), e.getCep()
        );
        Cliente c = new Cliente(e.getCpfCliente(), e.getNome(), e.getTelefone(),
                e.getEmail(), e.getSenha(), endereco);
        return c;
    }
}
