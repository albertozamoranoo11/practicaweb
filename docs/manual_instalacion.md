# Manual de Instalación

## Requisitos

* Java 17
* Oracle Database XE
* IntelliJ IDEA
* Git
* Maven Wrapper (incluido en el proyecto)

## Clonar el proyecto

```bash
git clone https://github.com/albertozamoranoo11/practicaweb.git
```

## Base de Datos

1. Abrir Oracle SQL Developer.
2. Crear una conexión a Oracle.
3. Ejecutar el archivo:

```text
database/script_bd.sql
```

Esto creará:

* Tablas
* Relaciones
* Datos de prueba
* Procedimientos almacenados

## Configuración

Abrir:

```text
src/main/resources/application.properties
```

Configurar los datos de conexión:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=PRACTICA_PRODUCTOS
spring.datasource.password=practica123
```

## Ejecución

Desde IntelliJ:

1. Abrir el proyecto.
2. Ejecutar la clase:

```text
PracticawebApplication
```

O desde terminal:

```bash
.\mvnw spring-boot:run
```

## Swagger

Una vez iniciada la aplicación acceder a:

```text
http://localhost:8080/swagger-ui/index.html
```

## Publicado

El archivo compilado se encuentra en:

```text
publicados/practicaweb-0.0.1-SNAPSHOT.jar
```
