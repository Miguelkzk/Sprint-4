package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {
    //busca articulos que esten activos
    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.fecha_baja IS NULL OR articulo_insumo.fecha_baja < articulo_insumo.fecha_alta;",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchbyalta(Pageable pageable);
    //Busca los articulos que esten bajo de stock
    @Query(
            value = "SELECT A.* FROM ARTICULO_INSUMO  A  JOIN UNIDAD_MEDIDA U ON A.ID_UNIDAD_MEDIDA=U.ID WHERE A.STOCK_ACTUAL<A.STOCK_MINIMO OR A.STOCK_ACTUAL <=(A.STOCK_MINIMO*0.2);",
            nativeQuery = true

    )
    Page<ArticuloInsumo> searchbystock(Pageable pageable);
}
