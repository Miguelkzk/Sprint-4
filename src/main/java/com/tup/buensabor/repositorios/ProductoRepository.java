package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {

    @Query(
            value = "SELECT * FROM Producto WHERE Producto.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Producto> searchnativo(@Param("filtro")String filtro, Pageable pageable);


}
