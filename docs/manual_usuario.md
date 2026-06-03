# Manual de Usuario

## Descripción

La aplicación permite administrar productos mediante servicios REST.

Las operaciones disponibles son:

* Consultar productos
* Agregar productos
* Actualizar productos
* Eliminar productos

## Acceso a Swagger

Iniciar la aplicación y acceder a:

```text
http://localhost:8080/swagger-ui/index.html
```

## Consultar Productos

Seleccionar:

```text
GET /api/productos
```

Presionar:

```text
Try it out
```

Después:

```text
Execute
```

El sistema mostrará el listado de productos registrados.

## Agregar Producto

Seleccionar:

```text
POST /api/productos
```

Ejemplo:

```json
{
  "clave": "JAB001",
  "nombre": "Jabon Liquido",
  "precio": 45.50,
  "tipoProductoId": 1,
  "activo": 1
}
```

Presionar:

```text
Execute
```

## Actualizar Producto

Seleccionar:

```text
PUT /api/productos/{id}
```

Ingresar el identificador del producto y los nuevos datos.

Presionar:

```text
Execute
```

## Eliminar Producto

Seleccionar:

```text
DELETE /api/productos/{id}
```

Ingresar el identificador del producto.

Presionar:

```text
Execute
```

## Resultado

Las operaciones realizadas se reflejan directamente en la base de datos Oracle mediante procedimientos almacenados.
