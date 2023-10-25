package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.ArticuloInsumo;
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
            Page<Pedido> pedidos=pedidoRepository.searchbyestado(filtro,pageable);
            return pedidos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
    @Override
    public Page<Pedido> searchbycliente(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedidos=pedidoRepository.searchbycliente(filtro,pageable);
            return pedidos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
    @Override
    public Page<Pedido> searchDetallePedido(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedidos=pedidoRepository.searchDetallePedido(filtro, pageable);
            return pedidos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
    @Override
    public Page<Pedido> searchbyFinanza(String filtro1,String flitro2, Pageable pageable) throws Exception {
        try{
            Page<Pedido> finanza=pedidoRepository.searchbyFinanza(filtro1,flitro2,pageable);
            return finanza;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
}
