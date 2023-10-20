package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {
}
