package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Factura;
import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(
            value = "SELECT F.* FROM FACTURA F JOIN DETALLE_FACTURA DF ON F.ID=DF.ID_FACTURA " +
                    "WHERE F.FECHA_FACTURACION BETWEEN %:filtro1% AND %:filtro2% ",
            nativeQuery = true
    )
    Page<Factura> search(@Param("filtro1") String filtro1, @Param("filtro2") String filtro2, Pageable pageable);
    @Query(
            value = "SELECT F.* FROM FACTURA AS F JOIN PEDIDO ON F.id_pedido = PEDIDO.id WHERE PEDIDO.id = %:filtro",
            nativeQuery = true
    )
    Page<Factura> searchFacturaPedido(@Param("filtro") String filtro1, Pageable pageable);
}