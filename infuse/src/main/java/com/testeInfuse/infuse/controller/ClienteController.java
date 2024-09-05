package com.testeInfuse.infuse.controller;


import lombok.RequiredArgsConstructor;
import com.testeInfuse.infuse.model.cliente.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testeInfuse.infuse.service.ClienteService;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {


    private final ClienteService service;

    @GetMapping
    public ResponseEntity<Page<ClienteDto>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = service.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }



}
