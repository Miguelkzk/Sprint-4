package com.tup.buensabor.servicies;

import com.tup.buensabor.DTO.BuscarEntreFechasDTO;
import com.tup.buensabor.DTO.DTORankingClientes;
import com.tup.buensabor.DTO.RankingProductoDto;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {
    Page<Cliente> searchRanking(Pageable pageable) throws Exception;
    Page<Cliente> searchRankingFecha(String filtro1,String filtro2, Pageable pageable) throws Exception;
    Page<Cliente> searchDetallePedido(Pageable pageable) throws Exception;
    List<DTORankingClientes> rankingClientes(Date desde, Date hasta) throws Exception;
   //List<DTORankingClientes> traerRankingClientes(BuscarEntreFechasDTO buscarEntreFechasDTO) throws Exception;
}


