package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService extends BaseService<Pedido,Long> {
    Page<Pedido> search(String filtro, Pageable pageable) throws Exception;
}
