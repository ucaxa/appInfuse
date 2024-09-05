package com.testeInfuse.infuse.service.impl;

import com.testeInfuse.infuse.datasource.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import com.testeInfuse.infuse.model.cliente.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.testeInfuse.infuse.service.ClienteService;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository repository;

    @Override
    public Page<ClienteDto> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(ClienteDto::new);
    }



}
