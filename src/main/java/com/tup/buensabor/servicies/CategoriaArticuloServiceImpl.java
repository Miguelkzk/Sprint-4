package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.CategoriaArticulo;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.CategoriaArticuloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CategoriaArticuloServiceImpl extends BaseServiceImpl<CategoriaArticulo, Long> implements CategoriaArticuloService {

    @Autowired
    private CategoriaArticuloRepository categoriaArticuloRepository;

    public CategoriaArticuloServiceImpl(BaseRepository<CategoriaArticulo, Long> baseRepository) {
        super(baseRepository);
    }

    public Page<CategoriaArticulo> searchbyalta(Pageable pageable) throws Exception {
        try{
            Page<CategoriaArticulo> CategoriaArticulo=categoriaArticuloRepository.searchbyalta(pageable);
            return CategoriaArticulo;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }

}
