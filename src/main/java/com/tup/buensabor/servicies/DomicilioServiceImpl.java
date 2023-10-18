package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Domicilio;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl (BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }
}
