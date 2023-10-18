package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.servicies.DetallepedidoImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/DetallePedido")
public class DetallepedidoController extends BaseControllerImpl<DetallePedido, DetallepedidoImpl> {
}
