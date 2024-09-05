package com.testeInfuse.infuse.datasource.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table
@Entity(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_controle", nullable = false)
    private Long numeroControle;

    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

    @Column(name = "quantidade", nullable = true)
    private Integer quantidade;

    @Column(name = "valor_total_pedido", nullable = true)
    private BigDecimal valorTotalPedido;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;

}
