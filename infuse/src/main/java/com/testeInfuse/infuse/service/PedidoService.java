package com.testeInfuse.infuse.service;

import com.testeInfuse.infuse.model.pedido.PedidoDto;
import com.testeInfuse.infuse.model.pedido.PedidoListagemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PedidoService {

    PedidoListagemDto cadastrar(PedidoDto dto);
    Page<PedidoListagemDto> listarPedidosPorNumeroControleOuDataOuTodos(Long numeroControle, LocalDateTime data, Pageable paginacao);
    Integer verificarQuantidadeInformada(PedidoDto dto);
    LocalDateTime verificaSeDataCadastroFoiInformada(PedidoDto dto);
    BigDecimal retornaValorTotalEAplicDescontoCasoExista(PedidoDto dto);

}
