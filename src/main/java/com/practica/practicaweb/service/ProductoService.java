package com.practica.practicaweb.service;

import com.practica.practicaweb.dto.ProductoRequest;
import com.practica.practicaweb.dto.ProductoResponse;
import com.practica.practicaweb.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<ProductoResponse> buscarProductos(String clave, Long tipoProductoId) {
        return repository.buscarProductos(clave, tipoProductoId);
    }

    public void guardarProducto(ProductoRequest request) {
        repository.guardarProducto(request);
    }

    public void actualizarProducto(Long productoId, ProductoRequest request) {
        repository.actualizarProducto(productoId, request);
    }

    public void eliminarProducto(Long productoId) {
        repository.eliminarProducto(productoId);
    }
}