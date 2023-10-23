package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticuloInsumoservice extends BaseService<ArticuloInsumo,Long>{
    Page<ArticuloInsumo> searchbyalta(Pageable pageable) throws Exception;
    Page<ArticuloInsumo> searchbystock(Pageable pageable) throws Exception;
}
