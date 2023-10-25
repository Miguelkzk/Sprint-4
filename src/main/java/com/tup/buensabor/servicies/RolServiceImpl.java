package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Rol;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends BaseServiceImpl<Rol,Long> implements RolService{
    @Autowired
    private RolRepository rolRepository;
    public RolServiceImpl(BaseRepository<Rol,Long>baseRepository){
        super(baseRepository);
    }
}
