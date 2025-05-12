package com.tienda.bazar.Service;


import com.tienda.bazar.DTO.VentaDTO;
import com.tienda.bazar.DTO.VentaRequestDTO;
import com.tienda.bazar.Model.Cliente;
import com.tienda.bazar.Model.DetalleVenta;
import com.tienda.bazar.Model.Producto;
import com.tienda.bazar.Model.Venta;
import com.tienda.bazar.Repository.IClienteRepository;
import com.tienda.bazar.Repository.IProductoRepository;
import com.tienda.bazar.Repository.IVentaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService  implements IVentaService {

    @Autowired
    IClienteRepository clienteRepo;


    @Autowired
    IProductoRepository productoRepo;


     @Autowired
    IVentaRepository ventaRepository;


    @Override
    public String createVenta(Venta venta) {
       ventaRepository.save(venta);
        return "";
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> ventaParticular(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta updateVenta(Long codigoDeVenta, Venta ventaActualizada) {
        return ventaRepository.findById(codigoDeVenta).map(venta  -> {

            venta.setFechaVenta(ventaActualizada.getFechaVenta());
            venta.setTotal(ventaActualizada.getTotal());
            venta.setProductos(ventaActualizada.getProductos());
            venta.setUnCliente(ventaActualizada.getUnCliente());
            return ventaRepository.save(venta);
        }).orElseThrow(() -> new RuntimeException("Venta no encontrada") );

    }


    @Override
    public String deleteVenta(Long id) {
        ventaRepository.deleteById(id);
        return "";
    }

    @Override
    public Object[] obtenerVentaSumatoriaYCantidadPorFecha(LocalDate fecha) {
        return ventaRepository.findVentaSumatoriaYCantidadPorFecha(fecha);

    }

    @Override
    public VentaDTO obtenerVentaConMayorMonto() {
        Object[] resultado = (Object[]) ventaRepository.findVentaConMayorMonto();

        if (resultado == null) {
            throw new RuntimeException("No hay ventas registradas");
        }

        return new VentaDTO(
                (Long) resultado[0],  // codigoVenta
                (Double) resultado[1], // total
                ((Number) resultado[2]).intValue(), // cantidadProductos
                (String) resultado[3], // nombreCliente
                (String) resultado[4]  // apellidoCliente
        );
    }


}


