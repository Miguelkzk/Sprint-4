package com.tup.buensabor.repositorios;

import com.tup.buensabor.DTO.DTORankingClientes;
import com.tup.buensabor.DTO.RankingProductoDto;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    @Query(
            value = "SELECT sum(f.total_venta) as total, c.nombre as persona, count(p.id) as cantidadPedidos " +
                    "FROM cliente as c " +
                    "LEFT JOIN pedido as p ON p.id_cliente LIKE p.id " +
                    "LEFT JOIN factura as f ON f.id LIKE f.id_pedido " +
                    "WHERE f.fecha_facturacion BETWEEN :desde AND :hasta " +
                    "GROUP BY c.id, c.nombre " +
                    "ORDER BY cantidadPedidos DESC ",
            nativeQuery = true
    )
    List<DTORankingClientes> rankingClientes(@Param("desde") Date desde, @Param("hasta") Date hasta);
 /*

    @Query(
            value = "SELECT new com.tup.buensabor.DTO.DTORankingClientes(dp.producto.denominacion, sum(f.total_venta) as total, c.nombre as persona, count(p.id) as cantidadPedidos " +
                    "FROM cliente as c " +
                    "LEFT JOIN pedido as p ON p.id_cliente LIKE p.id " +
                    "LEFT JOIN factura as f ON f.id LIKE f.id_pedido " +
                    "WHERE f.fecha_facturacion BETWEEN :fechaDesde AND :fechaHasta  " +
                    "GROUP BY c.id, c.nombre " +
                    "ORDER BY cantidadPedidos DESC )"
    )
    List<DTORankingClientes> rankingClientes(@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);

  */
}
// SELECT sum(f.total_venta) as total, c.nombre as persona, count(p.id) as cantidadPedidos FROM cliente as c LEFT JOIN pedido as p ON p.id_cliente LIKE p.id LEFT JOIN factura as f ON f.id LIKE f.id_pedido  GROUP BY c.id, c.nombre ORDER BY cantidadPedidos DESC