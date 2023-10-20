package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.CategoriaArticulo;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.CategoriaArticuloRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CategoriaArticuloServiceImpl extends BaseServiceImpl<CategoriaArticulo, Long> implements CategoriaArticuloService {

    @Autowired
    private CategoriaArticuloRepository categoriaArticuloRepository;

    public CategoriaArticuloServiceImpl(BaseRepository<CategoriaArticulo, Long> baseRepository) {
        super(baseRepository);
    }
}
