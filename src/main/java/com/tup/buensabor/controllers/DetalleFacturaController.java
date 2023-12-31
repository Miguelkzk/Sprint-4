package com.tup.buensabor.controllers;
import com.tup.buensabor.entities.DetalleFactura;
import com.tup.buensabor.servicies.DetalleFacServiceImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(path = "/DetalleFactura")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacServiceImp>{
}
