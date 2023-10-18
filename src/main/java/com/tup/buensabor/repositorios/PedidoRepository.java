package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {
}
