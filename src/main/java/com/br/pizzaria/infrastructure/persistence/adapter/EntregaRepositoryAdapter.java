package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.Entrega;
import com.br.pizzaria.domain.repository.EntregaRepository;
import com.br.pizzaria.domain.valueobject.StatusEntrega;
import com.br.pizzaria.infrastructure.persistence.entity.EntregaJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.EntregaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntregaRepositoryAdapter implements EntregaRepository {

    private final EntregaJpaRepository jpaRepository;

    public EntregaRepositoryAdapter(EntregaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Entrega salvar(Entrega entrega) {
        return toDomain(jpaRepository.save(toJpa(entrega)));
    }

    @Override
    public Optional<Entrega> buscarPorId(Long idEntrega) {
        return jpaRepository.findById(idEntrega).map(this::toDomain);
    }

    @Override
    public Optional<Entrega> buscarPorPedido(Long idPedido) {
        return jpaRepository.findByIdPedido(idPedido).map(this::toDomain);
    }

    @Override
    public List<Entrega> listarPorFuncionario(String cpfFuncionario) {
        return jpaRepository.findByCpfFuncionario(cpfFuncionario)
                .stream().map(this::toDomain).toList();
    }

    private EntregaJpaEntity toJpa(Entrega e) {
        EntregaJpaEntity je = new EntregaJpaEntity();
        je.setIdEntrega(e.getIdEntrega());
        je.setCpfFuncionario(e.getCpfFuncionario());
        je.setIdPedido(e.getIdPedido());
        je.setStatusEntrega(e.getStatusEntrega() != null
                ? e.getStatusEntrega() : StatusEntrega.AGUARDANDO);
        je.setAvaliacaoCliente(e.getAvaliacaoCliente());
        je.setAvaliacaoEntregador(e.getAvaliacaoEntregador());
        return je;
    }

    private Entrega toDomain(EntregaJpaEntity je) {
        Entrega e = new Entrega(je.getCpfFuncionario(), je.getIdPedido());
        e.setIdEntrega(je.getIdEntrega());
        e.setStatusEntrega(je.getStatusEntrega());
        e.setAvaliacaoCliente(je.getAvaliacaoCliente());
        e.setAvaliacaoEntregador(je.getAvaliacaoEntregador());
        return e;
    }
}
