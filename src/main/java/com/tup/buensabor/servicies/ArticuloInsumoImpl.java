package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.repositorios.ArticuloInsumoRepository;
import com.tup.buensabor.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoservice {
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }
}
