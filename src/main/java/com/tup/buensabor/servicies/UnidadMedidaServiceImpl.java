package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.UnidadMedida;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida,Long> baseRepository){super(baseRepository);}


}
