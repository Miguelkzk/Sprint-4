package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(
            value = "SELECT * FROM Producto WHERE Producto.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Producto>searchnativo(@Param("filtro")String filtro);


}
