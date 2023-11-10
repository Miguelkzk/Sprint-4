package com.tup.buensabor.repositorios;

import com.tup.buensabor.DTO.RankingProductoDto;
import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {

    @Query(
            value = "SELECT * FROM Producto WHERE Producto.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Producto> searchbynombre(@Param("filtro")String filtro, Pageable pageable);

    @Query("SELECT new com.tup.buensabor.DTO.RankingProductoDto(dp.producto.denominacion, SUM(dp.cantidad)) FROM DetallePedido dp " +
            "WHERE dp.pedido.fechaPedido BETWEEN :fechaDesde AND :fechaHasta " +
            "GROUP BY dp.producto.denominacion")
    List<RankingProductoDto> buscarRankingProductos(@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);

}
