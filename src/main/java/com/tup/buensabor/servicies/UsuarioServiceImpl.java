package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositorios.BaseRepository;
import com.tup.buensabor.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl (BaseRepository<Usuario,Long> baseRepository){super(baseRepository);}

    @Override
    public Page<Usuario> searchUsuario (String filtro1, String filtro2, Pageable pageable) throws Exception {
        try{
            Page<Usuario> usuarios=usuarioRepository.searchUsuario(filtro1, filtro2, pageable);
            return usuarios;
        }catch (Exception e){
            throw new Exception((e.getMessage()));
        }
    }
}
