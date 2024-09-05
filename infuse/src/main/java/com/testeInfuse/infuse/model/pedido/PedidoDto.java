package com.testeInfuse.infuse.model.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoDto(Long id,
        @NotNull Long numeroControle,@NotBlank String nomeProduto, @NotNull @Positive BigDecimal valorUnitario,
         Integer quantidade,LocalDateTime dataCadastro, @NotNull Long clienteId
) {



}
