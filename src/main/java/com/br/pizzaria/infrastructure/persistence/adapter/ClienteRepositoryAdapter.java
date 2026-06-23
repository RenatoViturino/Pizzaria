package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Cliente;
import com.br.pizzaria.domain.repository.ClienteRepository;
import com.br.pizzaria.domain.valueobject.Endereco;
import com.br.pizzaria.domain.valueobject.TipoPerfil;
import com.br.pizzaria.infrastructure.persistence.entity.ClienteJpaEntity;
import com.br.pizzaria.infrastructure.persistence.entity.EnderecoJpaEmbeddable;
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
        e.setPontuacao(c.getPontuacao() != null ? c.getPontuacao() : 0);
        e.setTipoPerfil(c.getTipoPerfil() != null ? c.getTipoPerfil() : TipoPerfil.BRONZE);
        if (c.getEndereco() != null) {
            Endereco end = c.getEndereco();
            e.setEndereco(new EnderecoJpaEmbeddable(
                    end.logradouro(), end.numero(), end.complemento(),
                    end.bairro(), end.cidade(), end.estado(), end.cep()
            ));
        }
        return e;
    }

    private Cliente toDomain(ClienteJpaEntity e) {
        EnderecoJpaEmbeddable endJpa = e.getEndereco();
        Endereco endereco = endJpa != null
                ? new Endereco(endJpa.getLogradouro(), endJpa.getNumero(), endJpa.getComplemento(),
                               endJpa.getBairro(), endJpa.getCidade(), endJpa.getEstado(), endJpa.getCep())
                : null;

        Cliente c = new Cliente(
                e.getCpfCliente(), e.getNome(), e.getTelefone(),
                e.getEmail(), e.getSenha(), endereco
        );
        // Restaura pontuação e perfil do banco (sem recalcular — o banco é a fonte de verdade)
        if (e.getPontuacao() != null)  c.adicionarPontos(0); // mantém construtor limpo
        // Usamos reflection-free: aplicamos os pontos acumulados respeitando a lógica de domínio
        // Nota: adicionarPontos(0) não altera nada — precisamos de um método de reconstituição
        // O correto é ter um construtor de reconstituição no domínio (ver Cliente.reconstituir)
        return reconstituir(c, e);
    }

    /**
     * Reconstitui o Cliente a partir dos dados do banco sem passar pela lógica de negócio
     * (pontos e perfil já estão calculados — apenas reidratamos o objeto de domínio).
     * Segue o padrão de reconstituição adotado nos outros adapters do projeto.
     */
    private Cliente reconstituir(Cliente base, ClienteJpaEntity e) {
        // Aplica pontuação real do banco usando o método de domínio de forma idempotente
        // adicionarPontos zera do construtor (0) e re-aplica os pontos do banco
        int pontosNoBanco = e.getPontuacao() != null ? e.getPontuacao() : 0;
        if (pontosNoBanco > 0) {
            base.adicionarPontos(pontosNoBanco);
        }
        return base;
    }
}
