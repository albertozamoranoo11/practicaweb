package com.practica.practicaweb.repository;

import com.practica.practicaweb.dto.ProductoRequest;
import com.practica.practicaweb.dto.ProductoResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {

    private final EntityManager entityManager;

    public ProductoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ProductoResponse> buscarProductos(String clave, Long tipoProductoId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("SP_BUSCAR_PRODUCTOS");

        query.registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_TIPO_PRODUCTO_ID", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_CURSOR", void.class, ParameterMode.REF_CURSOR);

        query.setParameter("P_CLAVE", clave);
        query.setParameter("P_TIPO_PRODUCTO_ID", tipoProductoId);

        query.execute();

        List<Object[]> resultados = query.getResultList();
        List<ProductoResponse> productos = new ArrayList<>();

        for (Object[] fila : resultados) {
            ProductoResponse producto = new ProductoResponse();

            producto.setProductoId(((Number) fila[0]).longValue());
            producto.setClave((String) fila[1]);
            producto.setNombre((String) fila[2]);
            producto.setPrecio(((Number) fila[3]).doubleValue());
            producto.setTipoProductoId(((Number) fila[4]).longValue());
            producto.setTipoProducto((String) fila[5]);
            producto.setActivo(((Number) fila[6]).intValue());

            productos.add(producto);
        }

        return productos;
    }

    public void guardarProducto(ProductoRequest request) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("SP_GUARDAR_PRODUCTO");

        query.registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_PRECIO", Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_TIPO_PRODUCTO_ID", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ACTIVO", Integer.class, ParameterMode.IN);

        query.setParameter("P_CLAVE", request.getClave());
        query.setParameter("P_NOMBRE", request.getNombre());
        query.setParameter("P_PRECIO", request.getPrecio());
        query.setParameter("P_TIPO_PRODUCTO_ID", request.getTipoProductoId());
        query.setParameter("P_ACTIVO", request.getActivo());

        query.execute();
    }

    public void actualizarProducto(Long productoId, ProductoRequest request) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("SP_ACTUALIZAR_PRODUCTO");

        query.registerStoredProcedureParameter("P_PRODUCTO_ID", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_PRECIO", Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_TIPO_PRODUCTO_ID", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ACTIVO", Integer.class, ParameterMode.IN);

        query.setParameter("P_PRODUCTO_ID", productoId);
        query.setParameter("P_CLAVE", request.getClave());
        query.setParameter("P_NOMBRE", request.getNombre());
        query.setParameter("P_PRECIO", request.getPrecio());
        query.setParameter("P_TIPO_PRODUCTO_ID", request.getTipoProductoId());
        query.setParameter("P_ACTIVO", request.getActivo());

        query.execute();
    }

    public void eliminarProducto(Long productoId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("SP_ELIMINAR_PRODUCTO");

        query.registerStoredProcedureParameter("P_PRODUCTO_ID", Long.class, ParameterMode.IN);
        query.setParameter("P_PRODUCTO_ID", productoId);

        query.execute();
    }
}