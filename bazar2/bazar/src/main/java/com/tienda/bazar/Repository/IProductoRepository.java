package com.tienda.bazar.Repository;


import com.tienda.bazar.Model.Producto;
import com.tienda.bazar.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByVenta(Venta venta);

    @Query(value = "SELECT * FROM Producto  WHERE cantidadDisponible <= :cantidad ", nativeQuery = true)
    List<Producto> findProductosConBajoStock(@Param("cantidad") Double cantidad);




}

