package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.servicies.BaseServiceImpl;
import com.tup.buensabor.servicies.ClienteServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    @GetMapping("/searchRanking")
    public ResponseEntity<?> searchRanking( Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRanking(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchRankingFecha")
    public ResponseEntity<?> searchRankingFecha(String filtro1,String filtro2, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRankingFecha(filtro1, filtro2, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchDetallePedido")
    public ResponseEntity<?> searchDetallePedido(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchDetallePedido(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/rankingPersonas")
    public ResponseEntity<?> rankingClientes(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date hasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.rankingClientes(desde, hasta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
