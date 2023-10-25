package com.tup.buensabor.servicies;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService extends BaseService<Usuario,Long> {
    Page<Usuario> searchUsuario(String filtro1, String filtro2, Pageable pageable) throws Exception;
}
