package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Localidad;
import com.tup.buensabor.servicies.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/localidad")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {
}
