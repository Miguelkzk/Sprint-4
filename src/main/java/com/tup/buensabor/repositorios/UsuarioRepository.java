package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
}
