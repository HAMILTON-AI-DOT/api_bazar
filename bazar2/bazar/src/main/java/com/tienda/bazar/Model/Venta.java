package com.tienda.bazar.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Entity
@Getter @Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDate fechaVenta;
    private Double total;


    // Relación de muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente unCliente;


    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos;

    public Venta() {
    }

    public Venta(Long codigo, LocalDate fecha_venta, Double total) {
        this.codigo = codigo;
        this.fechaVenta = fecha_venta;
        this.total = total;
    }
}
