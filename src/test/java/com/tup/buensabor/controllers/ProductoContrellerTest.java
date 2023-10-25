package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.servicies.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
@WebMvcTest(ProductoController.class)
public class ProductoContrellerTest {
    @MockBean
    private ProductoServiceImpl productoService;

    @Autowired
    private MockMvc mockMvc;

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

        when(productoService.search("Denominacion", pageable)).thenReturn(productosPage);


        mockMvc.perform(MockMvcRequestBuilders.get("/productos")
                        .param("parametro1", "Denominacion")
                        .contentType(MediaType.APPLICATION_JSON))  // Configurar el tipo de contenido
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Denominacion")); // Verificar el JSONPath

    }
}
