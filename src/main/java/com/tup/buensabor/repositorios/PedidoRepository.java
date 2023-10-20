package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {
    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Pedido> searchbyestado(@Param("filtro")String filtro, Pageable pageable);
}
