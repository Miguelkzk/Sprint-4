package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.CategoriaArticulo;
import com.tup.buensabor.servicies.CategoriaArticuloServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/categorias")

public class CategoriaArticuloController extends BaseControllerImpl<CategoriaArticulo, CategoriaArticuloServiceImpl> {

    @GetMapping("/searchbyalta")
    public ResponseEntity<?> searchbyalta(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchbyalta(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}