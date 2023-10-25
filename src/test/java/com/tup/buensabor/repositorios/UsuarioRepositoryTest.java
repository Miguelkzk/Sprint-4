package com.tup.buensabor.repositorios;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UsuarioRepositoryTest {


        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private ClienteRepository clienteRepository;


        @Test
        void searchUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsername("AnfranMax");
        usuario.setPassword("ElHuevoClacome");
        usuario.setAuth0Id("");
        usuario.setFechaAlta(new Date());
        usuario.setFechaBaja(new Date());
        usuario.setFechaModificacion(new Date());

        usuarioRepository.save(usuario);

        // Crea un cliente de prueba y asócialo al usuario
        Cliente cliente = new Cliente();
        cliente.setEmail("Eldiegosabe@gmail.com");
        cliente.setUsuario(usuario);
        clienteRepository.save(cliente);

        // Realiza la búsqueda con el correo electrónico de cliente y la contraseña de usuario
        Pageable pageable = Pageable.unpaged();
        Page<Usuario> usuariosPage = usuarioRepository.searchUsuario("Eldiegosabe@gmail.com", "ElHuevoClacome", pageable);

        // Obtiene los usuarios encontrados
        List<Usuario> usuariosEncontrados = usuariosPage.getContent();

        // Verifica que los usuarios coincidan
        assertEquals(1, usuariosEncontrados.size());
        Usuario usuarioEncontrado = usuariosEncontrados.get(0);
        assertEquals("AnfranMax", usuarioEncontrado.getUsername());
        assertEquals("ElHuevoClacome", usuarioEncontrado.getPassword());
    }

}