package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
