package com.tienda.bazar.Controller;


import com.tienda.bazar.DTO.VentaDTO;
import com.tienda.bazar.Model.Producto;
import com.tienda.bazar.Model.Venta;
import com.tienda.bazar.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;



    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaService.createVenta(venta);
        return "venta creada";
    }


    @GetMapping("/ventas/traer")
    public List<Venta> traerVentas(){
        return ventaService.getVentas();
    }

    @GetMapping("/ventas/traer/{id}")
    public Optional<Venta> getVenta (@PathVariable Long id){
        Optional<Venta> venta = ventaService.ventaParticular(id);
        return venta;
    }


    @GetMapping("ventas/total-y-cantidad/{fecha}")
    public ResponseEntity<Map<String, Object>> obtenerVentaSumatoriaYCantidad(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        Object[] result = ventaService.obtenerVentaSumatoriaYCantidadPorFecha(fecha);

        Map<String, Object> response = new HashMap<>();
        response.put("totalVentas", result[0]);
        response.put("cantidadVentas", result[1]);

        return ResponseEntity.ok(response);

    }



    @GetMapping("/ventas/mayor_venta")
    public ResponseEntity<VentaDTO> obtenerMayorVenta() {
        VentaDTO ventaDTO = ventaService.obtenerVentaConMayorMonto();
        return ResponseEntity.ok(ventaDTO);
    }




    @PutMapping("/ventas/actualizar/{codigo_venta}")
    public String editarVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        ventaService.updateVenta(codigo_venta, venta);
        return "Venta Actualizada con exito";
    }

    @DeleteMapping("/ventas/eliminar/{id}")
    public String elinarVenta (@PathVariable Long id){
        ventaService.deleteVenta(id);
        return "Venta Eliminada con exito";
    }
}
