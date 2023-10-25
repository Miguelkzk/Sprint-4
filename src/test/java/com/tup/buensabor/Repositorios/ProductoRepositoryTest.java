package com.tup.buensabor.Repositorios;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositorios.ClienteRepository;
import com.tup.buensabor.repositorios.ProductoRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductoRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void testSearchString() {
        Producto producto = new Producto();
        producto.setCosto(new BigDecimal(4514));
        producto.setDenominacion("Denominacion");
        producto.setDescripcion("Descripcion");
        producto.setFechaAlta(new Date());
        producto.setFechaBaja(new Date());
        producto.setFechaModificacion(new Date());
        producto.setTiempoEstimadoCocina(45);
        producto.setUrlImagen("imagen.jpg");
        producto.setPrecioVenta(new BigDecimal(45644));

        List<Producto> listEnviada = new ArrayList<>();
        listEnviada.add(producto);

        entityManager.persist(producto);
        entityManager.flush();

        Pageable pageable = Pageable.unpaged();
        Page<Producto> productosPage = productoRepository.searchbynombre("Denominacion", pageable);

        List<Producto> productosEncontrados = productosPage.getContent();

        assertEquals(listEnviada, productosEncontrados);



       // Page<Producto> productoPage = productoRepository.searchbynombre("Denominacion", pageable);
        //ssertEquals(listEnviada, productoRepository.searchbynombre("Denominacion", pageable));
        //assertEquals(1, productoPage.getTotalElements());
    }


}