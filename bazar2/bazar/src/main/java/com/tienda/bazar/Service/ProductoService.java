package com.tienda.bazar.Service;


import com.tienda.bazar.Model.Producto;
import com.tienda.bazar.Model.Venta;
import com.tienda.bazar.Repository.IProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {



  @Autowired
    IProductoRepository productoRepository;


    @Override
    public String createProducto(Producto producto) {
       productoRepository.save(producto);
        return "Producto creado exitosamente";
    }


    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> getProducto(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            return List.of(productoOptional.get());
        } else {
            return List.of();
        }
    }


    @Transactional
    @Override
    public Producto updateProducto(Long codigo, Producto productoActualizado) {
        return productoRepository.findById(codigo).map(producto -> {

            producto.setNombre(productoActualizado.getNombre());
            producto.setMarca(productoActualizado.getMarca());
            producto.setCosto(productoActualizado.getCosto());
            producto.setCantidad_disponible(productoActualizado.getCantidad_disponible());
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("producto no encontrado"));
    }


    @Override
    public String deleteProducto(Long id) {
        productoRepository.deleteById(id);
        return "Producto eliminado con exito!!";
    }

    @Override
    public List<Producto> obtenerProductosPorVenta(Long ventaId) {
        Venta venta = new Venta();
        venta.setCodigo(ventaId);
        return productoRepository.findByVenta(venta);
    }

    @Override
    public List<Producto> obtenerProductosConBajaCantidad() {


        return productoRepository.findProductosConBajoStock(5.0);
    }


}



