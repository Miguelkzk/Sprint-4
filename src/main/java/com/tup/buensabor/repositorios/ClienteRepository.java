package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
