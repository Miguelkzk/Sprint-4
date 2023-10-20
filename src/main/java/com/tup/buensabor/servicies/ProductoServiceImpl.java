package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.ProductoRepository;
import org.apache.tomcat.websocket.WsIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto,Long> implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public List<Producto> search(String filtro) throws Exception {
        try{
            List<Producto> productos=productoRepository.searchnativo(filtro);
            return productos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
}
