package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.servicies.ArticuloInsumoImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoImpl> {
    @GetMapping("/searchbyalta")
    public ResponseEntity<?> searchbyalta(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchbyalta(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchbystock")
    public ResponseEntity<?> searchbystock(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchbystock(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
