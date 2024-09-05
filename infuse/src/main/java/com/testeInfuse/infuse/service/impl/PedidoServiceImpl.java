package com.testeInfuse.infuse.service.impl;


import com.testeInfuse.infuse.datasource.repository.ClienteRepository;
import com.testeInfuse.infuse.datasource.repository.PedidoRepository;
import com.testeInfuse.infuse.model.factory.PedidoFactory;
import com.testeInfuse.infuse.model.pedido.PedidoDto;
import com.testeInfuse.infuse.model.pedido.PedidoListagemDto;
import com.testeInfuse.infuse.model.pedido.validacoes.ValidadorDePedidos;
import com.testeInfuse.infuse.service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private List<ValidadorDePedidos> validadorDePedidos;

    @Override
    public PedidoListagemDto cadastrar(PedidoDto dto) {


        validadorDePedidos.forEach(v-> v.validar(dto));
        var cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(EntityNotFoundException::new);
        var pedido = PedidoFactory.create(dto);
        pedido.setQuantidade(verificarQuantidadeInformada(dto));
        pedido.setValorTotalPedido(retornaValorTotalEAplicDescontoCasoExista(dto));
        pedido.setCliente(cliente);
        pedido.setDataCadastro(verificaSeDataCadastroFoiInformada(dto));
        pedidoRepository.save(pedido);
        return new PedidoListagemDto(pedido);
    }

    @Override
    public Page<PedidoListagemDto> listarPedidosPorNumeroControleOuDataOuTodos(Long id, LocalDateTime data, Pageable paginacao) {
        if (id != null && data != null) {
            return pedidoRepository.findByIdAndDataCadastro(id, data, paginacao).map(PedidoListagemDto::new);
         }else if (id != null) {
             return pedidoRepository.findById(id, paginacao).map(PedidoListagemDto::new);
        } else if (data != null) {
             return pedidoRepository.findByDataCadastro(data, paginacao).map(PedidoListagemDto::new);
        } else {
            return pedidoRepository.findAll(paginacao).map(PedidoListagemDto::new);
        }

    }

    @Override
    public LocalDateTime verificaSeDataCadastroFoiInformada(PedidoDto dto){
        if(dto.dataCadastro()==null){
            return LocalDateTime.now();
        }
        else {
            return dto.dataCadastro();
        }
    }

    @Override
    public Integer verificarQuantidadeInformada(PedidoDto dto){
        if (dto.quantidade()==null){
            return  1;
        }
        else {
            return dto.quantidade();

        }
    }

    @Override
    public BigDecimal retornaValorTotalEAplicDescontoCasoExista(PedidoDto dto){
        var quantidade = (dto.quantidade()==null) ? 1: dto.quantidade();
        var valorTotal= dto.valorUnitario().multiply(BigDecimal.valueOf(quantidade));
        if (quantidade>=5 && quantidade<10){
               return  valorTotal.subtract(valorTotal.multiply(BigDecimal.valueOf(0.05)));
        }
        else if (quantidade>=10){
            return  valorTotal.subtract(valorTotal.multiply(BigDecimal.valueOf(0.05)));
        }
        return valorTotal;
    }
}
