package com.tienda.bazar.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Entity
@Getter @Setter
public class Producto {
    @Id
     private Long codigo_producto;


    private String nombre;
    private String marca;
    private Double costo;
    @Column(name = "cantidad_disponible")
    private Double cantidad_disponible;

    @ManyToOne
    @JoinColumn(name = "venta")
    private Venta venta;


    @Version
    private Long version;

    public Producto() {
    }


    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }

}
