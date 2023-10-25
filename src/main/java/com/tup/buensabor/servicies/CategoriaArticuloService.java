package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.CategoriaArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaArticuloService extends BaseService<CategoriaArticulo,Long> {

    Page<CategoriaArticulo> searchbyalta(Pageable pageable) throws Exception;

}
