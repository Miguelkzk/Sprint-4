package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository){
        super(baseRepository);
    }
}
