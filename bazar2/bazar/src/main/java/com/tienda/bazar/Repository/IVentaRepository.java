package com.tienda.bazar.Repository;


import com.tienda.bazar.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    // Consulta para obtener la sumatoria de total y la cantidad de ventas de una feha en especifico

    @Query(value = "SELECT SUM(v.total), COUNT(v) FROM Venta v WHERE v.fecha_venta = :fecha")
    Object[] findVentaSumatoriaYCantidadPorFecha(@Param("fecha") LocalDate fecha);



    @Query("SELECT v.codigo, v.total, COUNT(p), c.nombre, c.apellido " +
                  "FROM Venta v " +
                  "JOIN v.unCliente c " +
                  "JOIN Producto p ON p.venta = v " +
                  "GROUP BY v.codigo, v.total, c.nombre, c.apellido " +
                  "ORDER BY v.total DESC LIMIT 1")
    Object findVentaConMayorMonto();



}
