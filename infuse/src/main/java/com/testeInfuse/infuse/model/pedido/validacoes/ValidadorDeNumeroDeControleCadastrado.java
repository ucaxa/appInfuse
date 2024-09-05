package com.testeInfuse.infuse.model.pedido.validacoes;

import com.testeInfuse.infuse.datasource.repository.PedidoRepository;
import com.testeInfuse.infuse.model.ValidacaoException;
import com.testeInfuse.infuse.model.pedido.PedidoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorDeNumeroDeControleCadastrado implements ValidadorDePedidos {

     private final PedidoRepository repository;

    @Override
    public void validar(PedidoDto dto) {


      if (seExistemPedidosCadastrados()) {
          var pedido = repository.findByNumeroControle(dto.numeroControle());
          if (pedido !=null) {
              throw new ValidacaoException(" Já existe um pedido com o numero de controle informado");
          }
        }
     }

    public boolean seExistemPedidosCadastrados(){
        return repository.findAll().stream().count()>0;
    }
}
