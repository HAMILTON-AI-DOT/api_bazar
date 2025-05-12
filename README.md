# 🛒 API Bazar – Gestión de Ventas

Esta es una **API RESTful** desarrollada en **Spring Boot + MySQL** para gestionar productos, clientes y ventas de un bazar. Permite operar desde distintas interfaces como una web o una app mobile consumiendo la misma API.

---

## 📁 Estructura del Proyecto

```
├── src/
│   └── main/
│       ├── java/com/bazar/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── model/
│       │   ├── repository/
│       │   └── dto/
│       └── resources/
│           └── application.properties
├── bazar_db.sql
└── README.md
```

---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok

---

## ⚙️ Requisitos

- Java 17 o superior
- MySQL instalado
- Maven

---

## 🧑‍💻 Configuración Inicial

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/api-bazar.git
cd api-bazar
```

### 2. Crear la base de datos

Abrí tu cliente de MySQL (Workbench, DBeaver, etc.) y ejecutá el archivo:

```
bazar_db.sql
```

Esto creará la base `bazar_db` con tablas y datos de prueba.

---

### 3. Configurar `application.properties`

Ubicación: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bazar_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🧪 Endpoints Disponibles

### 🔹 Productos
- `GET /productos` – Listar todos
- `POST /productos/crear` – Crear nuevo
- `GET /productos/{codigo_producto}` – Obtener por ID
- `DELETE /productos/eliminar/{codigo_producto}`
- `PUT /productos/editar/{codigo_producto}`
- `GET /productos/falta_stock` – Productos con stock < 5

### 🔹 Clientes
- `GET /clientes`
- `POST /clientes/crear`
- `GET /clientes/{id_cliente}`
- `DELETE /clientes/eliminar/{id_cliente}`
- `PUT /clientes/editar/{id_cliente}`

### 🔹 Ventas
- `GET /ventas`
- `POST /ventas/crear`
- `GET /ventas/{codigo_venta}`
- `DELETE /ventas/eliminar/{codigo_venta}`
- `PUT /ventas/editar/{codigo_venta}`
- `GET /ventas/productos/{codigo_venta}` – Productos de una venta
- `GET /ventas/{fecha}` – Resumen por fecha
- `GET /ventas/mayor_venta` – Venta con mayor total

---




