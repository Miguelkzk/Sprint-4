package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    @Query(
            value = "SELECT cliente.* , usuario.id as usuario_id, usuario.username as username, usuario.password as contraseña, usuario.auth0_id as auth0_id FROM cliente JOIN usuario ON usuario.id = cliente.id_usuario WHERE cliente.email = %:filtro1% AND usuario.password = %:filtro2%" ,
            nativeQuery = true
    )
    Page<Usuario> searchUsuario(@Param("filtro1")String filtro1, @Param("filtro2")String filtro2, Pageable pageable);
}
