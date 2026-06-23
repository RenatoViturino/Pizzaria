package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.AtualizarStatusPedidoRequest;
import com.br.pizzaria.application.dto.request.CriarPedidoRequest;
import com.br.pizzaria.application.dto.response.ItemPedidoResponse;
import com.br.pizzaria.application.dto.response.PedidoResponse;
import com.br.pizzaria.application.usecase.pedido.AtualizarStatusPedidoUseCase;
import com.br.pizzaria.application.usecase.pedido.BuscarPedidoUseCase;
import com.br.pizzaria.application.usecase.pedido.CriarPedidoUseCase;
import com.br.pizzaria.domain.entity.ItemPedido;
import com.br.pizzaria.domain.entity.Pedido;
import com.br.pizzaria.domain.entity.Produto;
import com.br.pizzaria.domain.event.PedidoCriadoEvent;
import com.br.pizzaria.domain.event.PedidoStatusAlteradoEvent;
import com.br.pizzaria.domain.exception.ClienteNaoEncontradoException;
import com.br.pizzaria.domain.exception.PedidoNaoEncontradoException;
import com.br.pizzaria.domain.exception.ProdutoNaoEncontradoException;
import com.br.pizzaria.domain.repository.ClienteRepository;
import com.br.pizzaria.domain.repository.PedidoRepository;
import com.br.pizzaria.domain.repository.ProdutoRepository;
import com.br.pizzaria.domain.valueobject.StatusPedido;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService implements CriarPedidoUseCase, BuscarPedidoUseCase, AtualizarStatusPedidoUseCase {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ApplicationEventPublisher eventPublisher;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProdutoRepository produtoRepository,
                         ApplicationEventPublisher eventPublisher) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    @Transactional
    public PedidoResponse executar(CriarPedidoRequest request) {
        clienteRepository.buscarPorCpf(request.cpfCliente())
                .orElseThrow(() -> new ClienteNaoEncontradoException(request.cpfCliente()));

        List<ItemPedido> itens = request.itens().stream().map(itemReq -> {
            Produto produto = produtoRepository.buscarPorId(itemReq.idProduto())
                    .orElseThrow(() -> new ProdutoNaoEncontradoException(itemReq.idProduto()));
            produto.reduzirEstoque(itemReq.quantidade());
            produtoRepository.salvar(produto);
            return new ItemPedido(produto.getIdProduto(), itemReq.quantidade(), produto.getPreco());
        }).toList();

        Pedido pedido = new Pedido(request.cpfCliente(), itens);
        Pedido salvo = pedidoRepository.salvar(pedido);

        eventPublisher.publishEvent(new PedidoCriadoEvent(
                salvo.getIdPedido(),
                salvo.getCpfCliente(),
                salvo.getValorTotal(),
                salvo.getDataHora()
        ));

        return toResponse(salvo);
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoResponse buscarPorId(Long idPedido) {
        return pedidoRepository.buscarPorId(idPedido)
                .map(this::toResponse)
                .orElseThrow(() -> new PedidoNaoEncontradoException(idPedido));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoResponse> listarPorCliente(String cpfCliente) {
        return pedidoRepository.listarPorCliente(cpfCliente).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoResponse> listarTodos() {
        return pedidoRepository.listarTodos().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public PedidoResponse executar(AtualizarStatusPedidoRequest request) {
        Pedido pedido = pedidoRepository.buscarPorId(request.idPedido())
                .orElseThrow(() -> new PedidoNaoEncontradoException(request.idPedido()));

        StatusPedido statusAnterior = pedido.getStatus();
        StatusPedido novoStatus = StatusPedido.valueOf(request.novoStatus().toUpperCase());
        pedido.atualizarStatus(novoStatus);
        Pedido salvo = pedidoRepository.salvar(pedido);

        eventPublisher.publishEvent(new PedidoStatusAlteradoEvent(
                salvo.getIdPedido(),
                salvo.getCpfCliente(),
                statusAnterior,
                novoStatus,
                salvo.getDataHora()
        ));

        return toResponse(salvo);
    }

    private PedidoResponse toResponse(Pedido p) {
        List<ItemPedidoResponse> itens = p.getItens().stream().map(i ->
                new ItemPedidoResponse(
                        i.getIdItem(),
                        i.getIdProduto(),
                        i.getQuantidade(),
                        i.getPrecoUnitario(),
                        i.getSubtotal()
                )
        ).toList();
        return new PedidoResponse(
                p.getIdPedido(), p.getDataHora(), p.getStatus().name(),
                p.getValorTotal(), p.getCpfCliente(), itens
        );
    }
}
