package com.practica.practicaweb.controller;

import com.practica.practicaweb.dto.ProductoRequest;
import com.practica.practicaweb.dto.ProductoResponse;
import com.practica.practicaweb.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> buscarProductos(
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) Long tipoProductoId) {

        return ResponseEntity.ok(
                service.buscarProductos(clave, tipoProductoId)
        );
    }

    @PostMapping
    public ResponseEntity<String> guardarProducto(
            @Valid @RequestBody ProductoRequest request) {

        service.guardarProducto(request);

        return ResponseEntity.ok("Producto guardado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequest request) {

        service.actualizarProducto(id, request);

        return ResponseEntity.ok("Producto actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable Long id) {

        service.eliminarProducto(id);

        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}