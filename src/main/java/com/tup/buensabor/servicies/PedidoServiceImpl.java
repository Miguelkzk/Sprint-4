package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository){
        super(baseRepository);
    }
    @Override
    public Page<Pedido> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Page<Pedido> pedidos=pedidoRepository.searchbyestado(filtro,pageable);
            //Page<Producto> productos=productoRepository.searchbynombre(filtro,pageable);
            Page<Pedido> pedidos=pedidoRepository.searchbyestado(filtro,pageable);
            return pedidos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
}
