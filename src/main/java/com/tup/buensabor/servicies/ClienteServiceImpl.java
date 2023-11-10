package com.tup.buensabor.servicies;

import com.tup.buensabor.DTO.BuscarEntreFechasDTO;
import com.tup.buensabor.DTO.DTORankingClientes;
import com.tup.buensabor.DTO.RankingProductoDto;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Page<Cliente> searchRanking(Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchRanking(pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    public Page<Cliente> searchRankingFecha(String filtro1, String filtro2, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchRankingFecha(filtro1, filtro2, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    public Page<Cliente> searchDetallePedido(Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchDetallePedido(pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }



    @Override
    public List<DTORankingClientes> rankingClientes(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) throws Exception {
        try {
            List<DTORankingClientes> Clientes = clienteRepository.rankingClientes(desde, hasta);
            return Clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

/*
    @Override
    public List<DTORankingClientes> traerRankingClientes(BuscarEntreFechasDTO buscarEntreFechasDTO) throws Exception {
        try {
            List<DTORankingClientes> dtoRankingClientes = clienteRepository.rankingClientes(buscarEntreFechasDTO.getFechaDesde(), buscarEntreFechasDTO.getFechaHasta());
            for (DTORankingClientes dto: dtoRankingClientes) {
                System.out.print(dto.getClass());
            }
            return dtoRankingClientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
        */


}
