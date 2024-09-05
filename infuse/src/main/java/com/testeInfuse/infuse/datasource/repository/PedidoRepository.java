package com.testeInfuse.infuse.datasource.repository;

import com.testeInfuse.infuse.datasource.entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Pedido findByNumeroControle(Long numeroControle);
    Page<Pedido> findByIdAndDataCadastro(Long id,LocalDateTime dataCadastro,Pageable pageabl);
    Page<Pedido> findById(Long numeroControle, Pageable pageable);
    Page<Pedido> findByDataCadastro(LocalDateTime dataCadastro, Pageable pageable);
}
