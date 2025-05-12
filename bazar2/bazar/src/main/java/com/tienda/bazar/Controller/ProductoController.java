package com.tienda.bazar.Controller;


import com.tienda.bazar.Model.Producto;
import com.tienda.bazar.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {



    @Autowired
    ProductoService productoService;


    @PostMapping("/productos/crear")
    public void crearProducto(@RequestBody Producto producto){
        productoService.createProducto(producto);
    }


    @GetMapping("/productos/traer")
    public List<Producto> traerProductos(){
       return productoService.getProductos();
    }

    @GetMapping("/productos/{id}")
    public List<Producto> getProducto (@PathVariable Long id){
      return productoService.getProducto(id);
    }


    @GetMapping("/productos/falta-stock")
    public ResponseEntity<List<Producto>> obtenerProductosConBajaCantidad() {
        List<Producto> productos = productoService.obtenerProductosConBajaCantidad();
        return ResponseEntity.ok(productos);
    }



    @GetMapping("/ventas/productos/{ventaId}")
    public ResponseEntity<List<Producto>> obtenerProductosPorVenta(@PathVariable Long ventaId) {
        List<Producto> productos = productoService.obtenerProductosPorVenta(ventaId);
        return ResponseEntity.ok(productos);
    }



    @PutMapping("/productos/actualizar/{codigo}")
    public void editarProductos(@PathVariable Long codigo, @RequestBody Producto producto){
        productoService.updateProducto(codigo,producto);
    }

    @DeleteMapping("/productos/eliminar/{id}")
    public void borrarProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
    }


}
