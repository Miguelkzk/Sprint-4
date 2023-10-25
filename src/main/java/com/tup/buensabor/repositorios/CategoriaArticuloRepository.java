package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.CategoriaArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaArticuloRepository extends BaseRepository<CategoriaArticulo, Long> {

    //Busca categorias activas
    @Query(
            value = "SELECT * FROM categoria WHERE categoria.fecha_baja IS NULL OR categoria.fecha_baja < categoria.fecha_alta;",
            nativeQuery = true
    )
    Page<CategoriaArticulo> searchbyalta(Pageable pageable);

}
