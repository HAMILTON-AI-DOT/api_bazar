package com.tienda.bazar.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class VentaRequestDTO {
    private Long clienteId;
    private List<DetalleVentaDTO> detalles;



    public static class DetalleVentaDTO {
        private Long productoId;
        private Integer cantidad;
        private Double precioUnitario;



    }
}
