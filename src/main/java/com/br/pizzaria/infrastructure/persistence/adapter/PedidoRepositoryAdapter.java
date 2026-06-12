package com.br.pizzaria.infrastructure.persistence.adapter;

import com.br.pizzaria.domain.entity.ItemPedido;
import com.br.pizzaria.domain.entity.Pedido;
import com.br.pizzaria.domain.repository.PedidoRepository;
import com.br.pizzaria.domain.valueobject.StatusPedido;
import com.br.pizzaria.infrastructure.persistence.entity.ItemPedidoJpaEntity;
import com.br.pizzaria.infrastructure.persistence.entity.PedidoJpaEntity;
import com.br.pizzaria.infrastructure.persistence.repository.PedidoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoRepositoryAdapter implements PedidoRepository {

    private final PedidoJpaRepository jpaRepository;

    public PedidoRepositoryAdapter(PedidoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        return toDomain(jpaRepository.save(toJpa(pedido)));
    }

    @Override
    public Optional<Pedido> buscarPorId(Long idPedido) {
        return jpaRepository.findById(idPedido).map(this::toDomain);
    }

    @Override
    public List<Pedido> listarPorCliente(String cpfCliente) {
        return jpaRepository.findByCpfCliente(cpfCliente).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Pedido> listarPorStatus(StatusPedido status) {
        return jpaRepository.findByStatus(status.name()).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Pedido> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    private PedidoJpaEntity toJpa(Pedido p) {
        PedidoJpaEntity e = new PedidoJpaEntity();
        e.setIdPedido(p.getIdPedido());
        e.setCpfCliente(p.getCpfCliente());
        e.setDataHora(p.getDataHora());
        e.setStatus(p.getStatus().name());
        e.setValorTotal(p.getValorTotal());
        List<ItemPedidoJpaEntity> itens = p.getItens().stream().map(i -> {
            ItemPedidoJpaEntity ie = new ItemPedidoJpaEntity();
            ie.setIdItem(i.getIdItem());
            ie.setIdProduto(i.getIdProduto());
            ie.setQuantidade(i.getQuantidade());
            ie.setPrecoUnitario(i.getPrecoUnitario());
            ie.setPedido(e);
            return ie;
        }).toList();
        e.setItens(itens);
        return e;
    }

    private Pedido toDomain(PedidoJpaEntity e) {
        List<ItemPedido> itens = e.getItens().stream().map(i ->
                new ItemPedido(i.getIdProduto(), i.getQuantidade(), i.getPrecoUnitario())
        ).toList();
        Pedido p = new Pedido(e.getCpfCliente(), itens);
        p.setIdPedido(e.getIdPedido());
        return p;
    }
}
