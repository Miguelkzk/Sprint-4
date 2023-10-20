package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida, Long> {
}
