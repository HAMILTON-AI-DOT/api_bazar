package com.tienda.bazar.Service;

import com.tienda.bazar.Model.Producto;

import java.util.List;

public interface IProductoService {

    //crear un producto
    public String createProducto(Producto producto);



    //traer todos los productos
    public List<Producto> getProductos();




    //traer un producto en particular
    public List<Producto> getProducto (Long id);






    //actualizar un producto
    public Producto updateProducto(Long codigo, Producto productoActualizado);





    //eliminar producto
    public String deleteProducto(Long id);





    //filtrar productos por venta
    public List<Producto> obtenerProductosPorVenta(Long ventaId);




    //filtrar productos con cantidad disponible menos a 5
    public List<Producto> obtenerProductosConBajaCantidad();
}
