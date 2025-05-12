package com.tienda.bazar.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter @Setter
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    private BigDecimal precioUnitario;

    // Muchas líneas de detalle pertenecen a una venta
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;


    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer cantidad, BigDecimal precioUnitario, Venta venta, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.venta = venta;
        this.producto = producto;
    }


}
