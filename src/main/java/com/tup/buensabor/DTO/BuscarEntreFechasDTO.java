package com.tup.buensabor.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class BuscarEntreFechasDTO {
    Date fechaDesde;
    Date fechaHasta;
}
