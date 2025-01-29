# Consultas para la Base de Datos

Este documento contiene las consultas principales utilizadas para interactuar con la base de datos del proyecto `ecommerce_coder_final`.

## Creación de la Base de Datos
```sql
CREATE DATABASE IF NOT EXISTS ecommerce_coder_final;
```

## Selección de la Base de Datos
```sql
USE ecommerce_coder_final;
```

## Consultas para Tablas

### Categorías
Obtiene todos los registros de la tabla `categorias`.
```sql
SELECT * FROM categorias;
```

### Clientes
Obtiene todos los registros de la tabla `clientes`.
```sql
SELECT * FROM clientes;
```

### Producto-Cliente
Obtiene todos los registros de la tabla `producto_cliente`.
```sql
SELECT * FROM producto_cliente;
```

### Productos
Obtiene todos los registros de la tabla `productos`.
```sql
SELECT * FROM productos;
```

### Detalles de Venta
Obtiene todos los registros de la tabla `venta_detalles`.
```sql
SELECT * FROM venta_detalles;
```

### Ventas
Obtiene todos los registros de la tabla `ventas`.
```sql
SELECT * FROM ventas;
```

---
Este archivo puede ser actualizado a medida que se agreguen nuevas tablas o consultas al proyecto.

