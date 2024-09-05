package com.testeInfuse.infuse.service;

import com.testeInfuse.infuse.model.cliente.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClienteService {
    Page<ClienteDto> listarTodos(Pageable paginacao);
}
