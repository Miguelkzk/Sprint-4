package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallepedidoImpl extends BaseServiceImpl<DetallePedido,Long>implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public DetallepedidoImpl(BaseRepository<DetallePedido, Long> baseRepository){
        super(baseRepository);
    }
}




