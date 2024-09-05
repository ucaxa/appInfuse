package com.testeInfuse.infuse.model.pedido;

import com.testeInfuse.infuse.datasource.entity.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoListagemDto(Long id, Long numeroControle, String nomeProduto, BigDecimal valorUnitario,
                                Integer quantidade, BigDecimal valorTotalPedido, LocalDateTime dataCadastro, Long clienteId) {

    public PedidoListagemDto(Pedido pedido) {
        this(pedido.getId(), pedido.getNumeroControle(), pedido.getNomeProduto(), pedido.getValorUnitario(),
                pedido.getQuantidade(), pedido.getValorTotalPedido(),pedido.getDataCadastro(),pedido.getCliente().getId());
    }

}
