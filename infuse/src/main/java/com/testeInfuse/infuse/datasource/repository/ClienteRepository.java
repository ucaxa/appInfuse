package com.testeInfuse.infuse.datasource.repository;

import com.testeInfuse.infuse.datasource.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
