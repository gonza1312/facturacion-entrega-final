package com.example.facturacionentregaproyectofinalroldan.services;

import com.example.facturacionentregaproyectofinalroldan.entities.Producto;
import com.example.facturacionentregaproyectofinalroldan.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    public ProductoRepository productoRepository;

    public Producto obtenerProducto(int id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }

    public Producto guardarProducto(Producto producto) {
        Producto productoGuardado = productoRepository.save(producto);
        return productoGuardado;
    }

    public void borrarProducto(int id) {
        productoRepository.deleteById(id);
    }

}
