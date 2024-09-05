package com.testeInfuse.infuse.model.cliente;

import com.testeInfuse.infuse.datasource.entity.Cliente;
import jakarta.validation.constraints.NotBlank;

public record ClienteDto(Long id,@NotBlank String nome) {
    public ClienteDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome());
    }
}
