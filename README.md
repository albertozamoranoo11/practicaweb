# Practica Web Java - Productos

Aplicación desarrollada con Spring Boot y Oracle para la administración de productos mediante servicios REST.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Oracle Database
- Maven
- Swagger OpenAPI

## Base de datos

El script de creación se encuentra en:

database/script_bd.sql

## Ejecución

1. Ejecutar el script de base de datos.
2. Configurar las credenciales de Oracle en `application.properties`.
3. Ejecutar `PracticawebApplication`.
4. Acceder a Swagger:

http://localhost:8080/swagger-ui/index.html

## Endpoints

GET /api/productos

POST /api/productos

PUT /api/productos/{id}

DELETE /api/productos/{id}