package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl (BaseRepository<Usuario,Long> baseRepository){super(baseRepository);}
}
