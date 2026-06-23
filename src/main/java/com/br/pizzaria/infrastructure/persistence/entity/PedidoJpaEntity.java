package com.br.pizzaria.infrastructure.persistence.entity;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade JPA: Pedido
 * cpfCliente como coluna simples (sem @ManyToOne) para alinhar com o adapter.
 * Status persistido como EnumType.STRING para legibilidade no banco.
 */
@Entity
@Table(name = "pedidos")
public class PedidoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "cpf_cliente", nullable = false, length = 11)
    private String cpfCliente;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusPedido status;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedidoJpaEntity> itens = new ArrayList<>();

    public Long getIdPedido()                      { return idPedido; }
    public void setIdPedido(Long v)                { this.idPedido = v; }
    public String getCpfCliente()                  { return cpfCliente; }
    public void setCpfCliente(String v)            { this.cpfCliente = v; }
    public LocalDateTime getDataHora()             { return dataHora; }
    public void setDataHora(LocalDateTime v)       { this.dataHora = v; }
    public StatusPedido getStatus()                { return status; }
    public void setStatus(StatusPedido v)          { this.status = v; }
    public BigDecimal getValorTotal()              { return valorTotal; }
    public void setValorTotal(BigDecimal v)        { this.valorTotal = v; }
    public List<ItemPedidoJpaEntity> getItens()    { return itens; }
    public void setItens(List<ItemPedidoJpaEntity> v) { this.itens = v; }
}
