package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.ArticuloInsumo;
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

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.id_cliente LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Pedido> searchbycliente(@Param("filtro")String filtro, Pageable pageable);

    @Query(
            value = "SELECT Pedido.*, SUM(total) AS TotalPedidos, SUM(total_costo) AS TotalGastoPedido, (total-total_costo) AS Ganancias FROM Pedido WHERE Pedido.fecha_alta >= %:filtro1% AND Pedido.fecha_alta <= %:filtro2%",
            nativeQuery = true
    )
    Page<Pedido> searchbyFinanza(@Param("filtro1") String filtro1, @Param("filtro2") String filtro2, Pageable pageable);

    @Query(
            value = "SELECT P.* FROM PEDIDO AS P JOIN detalle_pedido ON P.id = detalle_pedido.id_pedido WHERE P.id = %:filtro",
            nativeQuery = true
    )
    Page<Pedido> searchDetallePedido(@Param("filtro")String filtro, Pageable pageable);

}
