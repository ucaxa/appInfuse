package com.testeInfuse.infuse.controller;

import com.testeInfuse.infuse.model.pedido.PedidoDto;
import com.testeInfuse.infuse.model.pedido.PedidoListagemDto;
import com.testeInfuse.infuse.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final  PedidoService service;

    @PostMapping(consumes = {"application/json", "application/xml"})
    public ResponseEntity<PedidoListagemDto> cadastrar(@RequestBody @Valid PedidoDto dto, UriComponentsBuilder uriBuilder) {
        var pediddoDto = service.cadastrar(dto);
        URI endereco = uriBuilder.path("/pedidos/{id}").buildAndExpand(pediddoDto.id()).toUri();
        return ResponseEntity.created(endereco).body(pediddoDto);
    }

    @GetMapping
    public ResponseEntity<Page<PedidoListagemDto>> listar(PedidoDto dto, Pageable paginacao){
        var page = service.listarPedidosPorNumeroControleOuDataOuTodos(dto.id(), dto.dataCadastro(),paginacao);
        return ResponseEntity.ok(page);
    }


}
