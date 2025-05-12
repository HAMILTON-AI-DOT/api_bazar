package com.tienda.bazar.Service;

import com.tienda.bazar.DTO.VentaDTO;
import com.tienda.bazar.Model.Producto;
import com.tienda.bazar.Model.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVentaService {


    public String createVenta(Venta venta);


    public List<Venta> getVentas();

    Optional<Venta> ventaParticular (Long id);

    public Venta updateVenta(Long codigoDeVenta,Venta ventaActualizada);


    public String deleteVenta(Long id);


    public Object[] obtenerVentaSumatoriaYCantidadPorFecha(LocalDate fecha);

    public VentaDTO obtenerVentaConMayorMonto();






}
