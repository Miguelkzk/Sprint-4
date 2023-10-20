package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Localidad;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService {

@Autowired
    private LocalidadRepository localidadRepository;
public LocalidadServiceImpl(BaseRepository<Localidad,Long> baseRepository){super(baseRepository);}
}
