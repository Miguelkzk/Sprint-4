package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Factura;
import com.tup.buensabor.servicies.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
}
