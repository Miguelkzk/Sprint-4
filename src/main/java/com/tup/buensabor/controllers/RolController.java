package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Rol;
import com.tup.buensabor.servicies.RolServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rol")
public class RolController extends BaseControllerImpl<Rol, RolServiceImpl> {
}
