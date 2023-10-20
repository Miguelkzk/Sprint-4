package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.CategoriaArticulo;
import com.tup.buensabor.servicies.CategoriaArticuloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/categorias")

public class CategoriaController extends BaseControllerImpl<CategoriaArticulo, CategoriaArticuloServiceImpl> {
}