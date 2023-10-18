package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.servicies.ArticuloInsumoImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoImpl> {
}
