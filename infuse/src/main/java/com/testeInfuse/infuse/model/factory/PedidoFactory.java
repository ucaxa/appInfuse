package com.testeInfuse.infuse.model.factory;

import com.testeInfuse.infuse.datasource.entity.Pedido;
import com.testeInfuse.infuse.model.pedido.PedidoDto;

public class PedidoFactory {

    public static Pedido create(PedidoDto dto) {
        return Pedido.builder()
                .nomeProduto(dto.nomeProduto())
                .numeroControle(dto.numeroControle())
                .quantidade(dto.quantidade())
                .valorUnitario(dto.valorUnitario())
                 .build();
    }
}
