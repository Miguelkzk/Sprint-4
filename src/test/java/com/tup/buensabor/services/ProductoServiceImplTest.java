package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositorios.ProductoRepository;
import com.tup.buensabor.servicies.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManager;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ProductoServiceImplTest {

    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoServiceImpl productoService;

    @Test
    void testSearchString() throws Exception {

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


        Pageable pageable = Pageable.unpaged();

        Page<Producto> productosPage = new PageImpl<>(listEnviada);
        when(productoRepository.searchbynombre("Denominacion", pageable)).thenReturn(productosPage);

        assertEquals(listEnviada, productoService.search("Denominacion", pageable));

    }
}
