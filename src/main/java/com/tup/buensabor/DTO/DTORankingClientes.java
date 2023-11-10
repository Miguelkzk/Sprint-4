package com.tup.buensabor.DTO;

import com.tup.buensabor.entities.Cliente;

import java.math.BigDecimal;

public class DTORankingClientes {
    private Cliente cliente;
    private Long cantidadPedidos;
    private BigDecimal total;
    public DTORankingClientes(Cliente cliente, Long cantidadPedidos, BigDecimal total) {
        this.cliente=cliente;
        this.cantidadPedidos = cantidadPedidos;
        this.total = total;
    }
}
