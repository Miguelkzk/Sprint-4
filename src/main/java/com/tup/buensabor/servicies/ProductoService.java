package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Producto;

import java.util.List;

public interface ProductoService extends BaseService<Producto,Long> {
    List<Producto> search(String filtro) throws Exception;
}
