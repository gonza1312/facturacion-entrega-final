package com.example.facturacionentregaproyectofinalroldan.repositories;

import com.example.facturacionentregaproyectofinalroldan.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
