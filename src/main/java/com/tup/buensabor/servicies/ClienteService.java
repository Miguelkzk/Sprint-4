package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ClienteService extends BaseService<Cliente, Long> {
    Page<Cliente> searchRanking(Pageable pageable) throws Exception;
    Page<Cliente> searchRankingFecha(String filtro1,String filtro2, Pageable pageable) throws Exception;
    Page<Cliente> searchDetallePedido(Pageable pageable) throws Exception;
}
