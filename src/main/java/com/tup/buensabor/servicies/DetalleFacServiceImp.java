package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.DetalleFactura;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetalleFacServiceImp extends BaseServiceImpl<DetalleFactura,Long> implements DetalleFacService{
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    public DetalleFacServiceImp (BaseRepository<DetalleFactura,Long> baseRepository){super(baseRepository);}
}
