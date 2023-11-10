package com.tup.buensabor.servicies;

import com.tup.buensabor.DTO.BuscarEntreFechasDTO;
import com.tup.buensabor.DTO.RankingProductoDto;
import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService extends BaseService<Producto,Long> {
    Page<Producto> search(String filtro, Pageable pageable) throws Exception;
    public List<RankingProductoDto> traerRankingProductos(BuscarEntreFechasDTO buscarEntreFechasDTO) throws Exception;
}
