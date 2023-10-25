package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Factura;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface FacturaService extends BaseService<Factura,Long> {
    Page<Factura> search(String filtro1,String filtro2, Pageable pageable) throws Exception;
    Page<Factura> searchFacturaPedido(String filtro, Pageable pageable) throws Exception;
}
