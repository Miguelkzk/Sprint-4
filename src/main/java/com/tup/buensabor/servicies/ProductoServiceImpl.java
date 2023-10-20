package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto,Long> implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public Page<Producto> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Producto> productos=productoRepository.searchbynombre(filtro,pageable);
            return productos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }


}
