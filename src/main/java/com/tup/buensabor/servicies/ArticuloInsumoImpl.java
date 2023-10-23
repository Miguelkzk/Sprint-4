package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositorios.ArticuloInsumoRepository;
import com.tup.buensabor.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoservice {
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;


    public ArticuloInsumoImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public Page<ArticuloInsumo> searchbyalta(Pageable pageable) throws Exception {
        try{
            Page<ArticuloInsumo> articuloInsumos=articuloInsumoRepository.searchbyalta(pageable);
            return articuloInsumos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
    @Override
    public Page<ArticuloInsumo> searchbystock(Pageable pageable) throws Exception {
        try{
            Page<ArticuloInsumo> articuloInsumos=articuloInsumoRepository.searchbystock(pageable);
            return articuloInsumos;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
}
