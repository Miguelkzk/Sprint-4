package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Factura;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura,Long> implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public Page<Factura> search(String filtro1,String flitro2, Pageable pageable) throws Exception {
        try{
            Page<Factura> facturas=facturaRepository.search(filtro1, flitro2, pageable);
            return facturas;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    public Page<Factura> searchFacturaPedido(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Factura> facturas=facturaRepository.searchFacturaPedido(filtro, pageable);
            return facturas;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }

}
