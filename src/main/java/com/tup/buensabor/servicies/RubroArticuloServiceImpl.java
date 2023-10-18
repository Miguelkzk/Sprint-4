package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.RubroArticuloRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);
    }
}
