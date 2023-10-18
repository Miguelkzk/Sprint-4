package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.servicies.BaseServiceImpl;
import com.tup.buensabor.servicies.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {
}
