package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    //Trae el top de clientes
    @Query(
            value = "SELECT cliente.*, SUM(pedido.total) as total, COUNT(pedido.id) AS cantidad FROM cliente JOIN pedido ON pedido.id_cliente = cliente.id GROUP BY cliente.id, cliente.nombre  ORDER BY cantidad DESC" ,
            nativeQuery = true
    )
    Page<Cliente> searchRanking(Pageable pageable);
    @Query(
            value = "SELECT cliente.*, SUM(pedido.total) AS TotalPedidos FROM cliente JOIN pedido ON pedido.id_cliente = cliente.id WHERE pedido.fecha_alta >= %:filtro1% AND pedido.fecha_alta <= %:filtro2%" ,
            nativeQuery = true
    )
    Page<Cliente> searchRankingFecha(@Param("filtro1")String filtro1,@Param("filtro2")String filtro2,Pageable pageable);

    @Query(
            value = "SELECT cliente.* , dp.id as dp_id, dp.subtotal as dp_subtotal, dp.subtotal_costo as dp_subtotal_costo, dp.cantidad as dp_cantidad FROM cliente JOIN pedido ON pedido.id_cliente = cliente.id JOIN detalle_pedido dp ON pedido.id = dp.id_pedido" ,
            nativeQuery = true
    )
    Page<Cliente> searchDetallePedido(Pageable pageable);
}
