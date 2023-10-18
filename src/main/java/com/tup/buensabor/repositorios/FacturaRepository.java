package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends BaseRepository<Factura, Long> {
}
