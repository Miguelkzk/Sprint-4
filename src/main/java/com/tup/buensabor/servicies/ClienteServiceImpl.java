package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteServiceImpl (BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Page<Cliente> searchRanking( Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes=clienteRepository.searchRanking(pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    public Page<Cliente> searchRankingFecha (String filtro1,String filtro2,Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes=clienteRepository.searchRankingFecha(filtro1, filtro2, pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
    @Override
    public Page<Cliente> searchDetallePedido( Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes=clienteRepository.searchDetallePedido(pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }

}
