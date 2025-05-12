🛒 API Bazar – Gestión de Ventas
Esta es una API RESTful desarrollada en Spring Boot + MySQL para gestionar productos, clientes y ventas de un bazar. Permite operar desde distintas interfaces como una web o una app mobile consumiendo la misma API.

🚀 Tecnologías Utilizadas
Java 17+

Spring Boot

Spring Data JPA

MySQL

Maven

Lombok


🧪 Endpoints Disponibles
🔹 Productos
GET /productos – Listar todos

POST /productos/crear – Crear nuevo

GET /productos/{codigo_producto} – Obtener por ID

DELETE /productos/eliminar/{codigo_producto}

PUT /productos/editar/{codigo_producto}

GET /productos/falta_stock – Productos con stock < 5

🔹 Clientes
GET /clientes

POST /clientes/crear

GET /clientes/{id_cliente}

DELETE /clientes/eliminar/{id_cliente}

PUT /clientes/editar/{id_cliente}

🔹 Ventas
GET /ventas

POST /ventas/crear

GET /ventas/{codigo_venta}

DELETE /ventas/eliminar/{codigo_venta}

PUT /ventas/editar/{codigo_venta}

GET /ventas/productos/{codigo_venta} – Productos de una venta

GET /ventas/{fecha} – Resumen por fecha

GET /ventas/mayor_venta – Venta con mayor total



🧑‍🏫 Autor
Desarrollado por Mauro Rivas, 2025.
