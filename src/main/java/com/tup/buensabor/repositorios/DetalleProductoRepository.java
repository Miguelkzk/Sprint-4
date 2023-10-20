package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends BaseRepository<DetalleProducto,Long> {
}
