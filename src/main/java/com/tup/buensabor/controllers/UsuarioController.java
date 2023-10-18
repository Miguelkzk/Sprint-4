package com.tup.buensabor.controllers;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.servicies.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(path = "/usuarios")

public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {
}
