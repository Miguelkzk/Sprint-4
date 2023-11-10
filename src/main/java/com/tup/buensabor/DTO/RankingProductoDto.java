package com.tup.buensabor.DTO;

import lombok.Data;

@Data
public class RankingProductoDto {
    String nombreProducto;
    Long cantidadVendida;
    public RankingProductoDto(String nombreProducto, Long cantidadVendida) {
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;

    }
}
